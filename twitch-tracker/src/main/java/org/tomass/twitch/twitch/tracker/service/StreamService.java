package org.tomass.twitch.twitch.tracker.service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tomass.twitch.dao.StreamDao;
import org.tomass.twitch.dao.StreamDataDao;
import org.tomass.twitch.dao.TwitchUserDao;
import org.tomass.twitch.model.Stream;
import org.tomass.twitch.model.Stream.Association;
import org.tomass.twitch.model.Stream.OpAttribute;
import org.tomass.twitch.model.StreamData;
import org.tomass.twitch.model.TwitchUser;

import com.github.twitch4j.helix.domain.StreamList;

@Service
@Transactional
public class StreamService {

    @Autowired
    private StreamDao twitchStreamDao;
    @Autowired
    private StreamDataDao twitchStreamDataDao;
    @Autowired
    private TwitchUserDao twitchUserDao;

    public Stream createStream(Stream user) {
        return twitchStreamDao.insert(user);
    }

    public Stream getStream(Long id) {
        return twitchStreamDao.get(new Stream().withId(id).withInit_(Association.streamDatas));
    }

    public Integer updateStream(Stream user) {
        return twitchStreamDao.update(user);
    }

    public List<Stream> listStream() {
        return twitchStreamDao.list(new Stream());
    }

    public void createStreams(StreamList twitchUsers) {
        twitchUsers.getStreams().forEach(stream -> {

            Stream dbStream = new Stream();
            dbStream.setId(Long.valueOf(stream.getId()));
            dbStream.setUserId(Long.valueOf(stream.getUserId()));
            dbStream.setMature(BooleanUtils.toBoolean(stream.isMature()));
            dbStream.setStartedAt(LocalDateTime.ofInstant(stream.getStartedAtInstant(), ZoneId.of("Europe/Prague")));
            dbStream.setThumbnailUrl(stream.getThumbnailUrl());
            if (getStream(dbStream.getId()) == null) {
                createStream(dbStream);
            }
            StreamData dbData = new StreamData();
            dbData.setId(UUID.randomUUID().toString());
            if (StringUtils.isNotBlank(stream.getGameId())) {
                dbData.setGameId(Integer.valueOf(stream.getGameId()));
            }
            dbData.setGameName(stream.getGameName());
            dbData.setTitle(stream.getTitle());
            dbData.setViewerCount(stream.getViewerCount());
            dbData.setStream(dbStream);
            dbData.setTs(LocalDateTime.now());
            twitchStreamDataDao.insert(dbData);
        });
    }

    public void getStreamData(TwitchUser twitchUser) {
        Integer avgViewers = 0;
        Integer timeStreamed = 0;
        Integer hoursWatched = 0;
        Integer avgViewers30 = 0;
        Integer timeStreamed30 = 0;
        Integer hoursWatched30 = 0;
        YearMonth currentYearMonth = YearMonth.now();

        List<Stream> streams = twitchStreamDao.list(new Stream().withUserId(twitchUser.getId())
                .withStartedAt(LocalDateTime.now().minusDays(31)).withOp_(">", OpAttribute.startedAt));
        for (Stream stream : streams) {
            List<StreamData> datas = twitchStreamDataDao.list(new StreamData().withStream(stream));
            Integer viewerCount = 0;
            Integer dataCount = 0;
            LocalDateTime maxTime = LocalDateTime.MIN;
            for (StreamData data : datas) {
                viewerCount += data.getViewerCount();
                dataCount += 1;
                if (data.getTs().isAfter(maxTime)) {
                    maxTime = data.getTs();
                }

                //
                // if (YearMonth.from(data.getTs()).equals(currentYearMonth)) {
                // viewerCount = +data.getViewerCount();
                // dataCount = +1;
                // }
            }

            stream.setAvgViewers((float) ((float) viewerCount / dataCount));
            stream.setTimeStreamed((int) ChronoUnit.SECONDS.between(stream.getStartedAt(), maxTime));
            stream.setHoursWatched((int) (((float) stream.getTimeStreamed() / 3600) * stream.getAvgViewers()));
            stream.setEndAt(maxTime);
            updateStream(stream);
        }
    }

    public void getStreamData1(TwitchUser twitchUser) {
        YearMonth currentYearMonth = YearMonth.now();

        Float avgViewers = 0.0f;
        Integer avgViewerCount = 0;
        Integer timeStreamed = 0;
        Integer hoursWatched = 0;
        Integer avgViewerCount30 = 0;
        Float avgViewers30 = 0.0f;
        Integer timeStreamed30 = 0;
        Integer hoursWatched30 = 0;

        List<Stream> streams = twitchStreamDao.list(new Stream().withUserId(twitchUser.getId()));
        // .withStartedAt(LocalDateTime.now().minusDays(31)).withOp_(">", OpAttribute.startedAt));
        for (Stream stream : streams) {
            if (stream.getAvgViewers() == null || stream.getTimeStreamed() == null
                    || stream.getHoursWatched() == null) {
                continue;
            }

            avgViewerCount30 += (int) Duration.ofSeconds(stream.getTimeStreamed()).toMinutes() / 10;
            avgViewers30 += stream.getAvgViewers()*avgViewerCount300;

            timeStreamed30 += stream.getTimeStreamed();
            hoursWatched30 += stream.getHoursWatched();

            if (YearMonth.from(stream.getStartedAt()).equals(currentYearMonth)) {
                avgViewers += stream.getAvgViewers();
                avgViewerCount += (int) Duration.ofSeconds(stream.getTimeStreamed()).toMinutes() / 10;
                timeStreamed += stream.getTimeStreamed();
                hoursWatched += stream.getHoursWatched();
            }
        }

        if (avgViewerCount > 0) {
            twitchUser.setAvgViewers((float) (avgViewers / avgViewerCount));
        } else {
            twitchUser.setAvgViewers(0.0f);
        }
        if (avgViewerCount30 > 0) {
            twitchUser.setAvgViewers30((float) (avgViewers30 / avgViewerCount30));
        } else {
            twitchUser.setAvgViewers30(0.0f);
        }
        twitchUser.setTimeStreamed(timeStreamed);
        twitchUser.setTimeStreamed30(timeStreamed30);
        twitchUser.setHoursWatched(hoursWatched);
        twitchUser.setHoursWatched30(hoursWatched30);
        twitchUserDao.update(twitchUser);
    }

    public void createStream(com.github.twitch4j.helix.domain.Stream stream) {
        Stream dbStream = new Stream();
        dbStream.setId(Long.valueOf(stream.getId()));
        dbStream.setUserId(Long.valueOf(stream.getUserId()));
        dbStream.setMature(BooleanUtils.toBoolean(stream.isMature()));
        dbStream.setStartedAt(LocalDateTime.ofInstant(stream.getStartedAtInstant(), ZoneId.of("Europe/Prague")));
        dbStream.setThumbnailUrl(stream.getThumbnailUrl());
        if (getStream(dbStream.getId()) == null) {
            createStream(dbStream);
        }
        StreamData dbData = new StreamData();
        dbData.setId(UUID.randomUUID().toString());
        if (StringUtils.isNotBlank(stream.getGameId())) {
            dbData.setGameId(Integer.valueOf(stream.getGameId()));
        }
        dbData.setGameName(stream.getGameName());
        dbData.setTitle(stream.getTitle());
        dbData.setViewerCount(stream.getViewerCount());
        dbData.setStream(dbStream);
        dbData.setTs(LocalDateTime.now());
        twitchStreamDataDao.insert(dbData);
    }

    public void createStreamData(com.github.twitch4j.helix.domain.Stream stream, Instant instant) {
        StreamData dbData = new StreamData();
        dbData.setId(UUID.randomUUID().toString());
        if (StringUtils.isNotBlank(stream.getGameId())) {
            dbData.setGameId(Integer.valueOf(stream.getGameId()));
        }
        dbData.setGameName(stream.getGameName());
        dbData.setTitle(stream.getTitle());
        dbData.setViewerCount(stream.getViewerCount());
        dbData.setStream(new Stream().withId(Long.parseLong(stream.getId())));
        dbData.setTs(LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Prague")));
        twitchStreamDataDao.insert(dbData);
    }

}

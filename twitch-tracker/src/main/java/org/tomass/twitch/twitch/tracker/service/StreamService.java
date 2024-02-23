package org.tomass.twitch.twitch.tracker.service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tomass.twitch.dao.StreamDao;
import org.tomass.twitch.dao.StreamDataDao;
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

            for (StreamData data : datas) {
                if (YearMonth.from(data.getTs()).equals(currentYearMonth)) {
                    viewerCount = +data.getViewerCount();
                    dataCount = +1;
                }
            }
            
        }
    }

}

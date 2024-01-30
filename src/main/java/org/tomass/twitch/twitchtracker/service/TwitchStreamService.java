package org.tomass.twitch.twitchtracker.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tomass.twitch.twitchtracker.dao.TwitchStreamDao;
import org.tomass.twitch.twitchtracker.dao.TwitchStreamDataDao;
import org.tomass.twitch.twitchtracker.model.TwitchStream;
import org.tomass.twitch.twitchtracker.model.TwitchStreamData;
import org.tomass.twitch.twitchtracker.model.TwitchStream.Association;

import com.github.twitch4j.helix.domain.StreamList;

@Service
@Transactional
public class TwitchStreamService {

    @Autowired
    private TwitchStreamDao twitchStreamDao;
    @Autowired
    private TwitchStreamDataDao twitchStreamDataDao;

    public TwitchStream createTwitchStream(TwitchStream user) {
        return twitchStreamDao.insert(user);
    }

    public TwitchStream getTwitchStream(Long id) {
        return twitchStreamDao.get(new TwitchStream().withId(id).withInit_(Association.twitchStreamDatas));
    }

    public Integer updateTwitchStream(TwitchStream user) {
        return twitchStreamDao.update(user);
    }

    public List<TwitchStream> listTwitchStream() {
        return twitchStreamDao.list(new TwitchStream());
    }

    public void createStreams(StreamList twitchUsers) {
        twitchUsers.getStreams().forEach(stream -> {

            TwitchStream dbStream = new TwitchStream();
            dbStream.setId(Long.valueOf(stream.getId()));
            dbStream.setUserId(Long.valueOf(stream.getUserId()));
            dbStream.setMature(BooleanUtils.toBoolean(stream.isMature()));
            dbStream.setStartedAt(LocalDateTime.ofInstant(stream.getStartedAtInstant(), ZoneId.of("Europe/Prague")));
            dbStream.setThumbnailUrl(stream.getThumbnailUrl());
            if (getTwitchStream(dbStream.getId()) == null) {
                createTwitchStream(dbStream);
            }
            TwitchStreamData dbData = new TwitchStreamData();
            if (StringUtils.isNotBlank(stream.getGameId())) {
                dbData.setGameId(Integer.valueOf(stream.getGameId()));
            }
            dbData.setGameName(stream.getGameName());
            dbData.setTitle(stream.getTitle());
            dbData.setViewerCount(stream.getViewerCount());
            dbData.setTwitchStream(dbStream);
            dbData.setTs(LocalDateTime.now());
            twitchStreamDataDao.insert(dbData);
        });
    }

}

package org.tomass.twitch.twitch.tracker.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tomass.twitch.dao.StreamDao;
import org.tomass.twitch.dao.StreamDataDao;
import org.tomass.twitch.model.Stream;
import org.tomass.twitch.model.Stream.Association;

@Service
@Transactional
public class StreamService {

    @Autowired
    private StreamDao twitchStreamDao;

    public Stream createStream(Stream user) {
        return twitchStreamDao.insert(user);
    }

    public Stream getStream(Long id) {
        return twitchStreamDao.get(new Stream().withId(id).withInit_(Association.streamDatas));
    }

    public Integer updateStream(Stream strean) {
        return twitchStreamDao.update(strean);
    }

    public List<Stream> listStream() {
        return twitchStreamDao.list(new Stream());
    }

}

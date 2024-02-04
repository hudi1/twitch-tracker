package org.tomass.twitch.chat.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tomass.twitch.dao.TwitchUserDao;
import org.tomass.twitch.model.TwitchUser;

@Service
public class TwitchUserService {

    @Autowired
    private TwitchUserDao twitchUserDao;

    public TwitchUser createStreamUser(TwitchUser streamUser) {
        return twitchUserDao.insert(streamUser);
    }

    public TwitchUser getStreamUser(Long id) {
        return twitchUserDao.get(new TwitchUser().withId(id));
    }

    public int updateStreamUser(TwitchUser streamUser) {
        return twitchUserDao.update(streamUser);
    }

    public int deleteStreamUser(TwitchUser streamUser) {
        return twitchUserDao.delete(streamUser);
    }

    public List<TwitchUser> listStreamUser(TwitchUser streamUser) {
        return twitchUserDao.list(streamUser);
    }

}
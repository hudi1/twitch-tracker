package org.tomass.twitch.twitch.tracker.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tomass.twitch.dao.TwitchUserDao;
import org.tomass.twitch.model.TwitchUser;

@Service
@Transactional
public class TwitchUserService {

    @Autowired
    private TwitchUserDao twitchUserDao;

    public TwitchUser createTwitchUser(TwitchUser user) {
        return twitchUserDao.insert(user);
    }

    public TwitchUser getTwitchUser(Long id) {
        return twitchUserDao.get(new TwitchUser().withId(id));
    }

    public Integer updateTwitchUser(TwitchUser user) {
        return twitchUserDao.update(user);
    }

    public List<TwitchUser> listTwitchUser() {
        return twitchUserDao.list(new TwitchUser());
    }
    
    

}

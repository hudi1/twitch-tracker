package org.tomass.twitch.twitch.tracker.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tomass.twitch.dao.TwitchUserDao;
import org.tomass.twitch.model.TwitchUser;

import com.github.twitch4j.helix.domain.UserList;

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

    public void createUsers(UserList twitchUsers) {
        twitchUsers.getUsers().forEach(user -> {

            TwitchUser dbUser = new TwitchUser();
            dbUser.setId(Long.valueOf(user.getId()));
            dbUser.setLogin(user.getLogin());
            dbUser.setDisplayName(user.getDisplayName());
            dbUser.setType(user.getType());
            dbUser.setBroadcasterType(user.getBroadcasterType());
            dbUser.setDescription(user.getDescription());
            dbUser.setProfileImageUrl(user.getProfileImageUrl());
            dbUser.setOfflineImageUrl(user.getOfflineImageUrl());
            dbUser.setCreatedAt(LocalDateTime.ofInstant(user.getCreatedAt(), ZoneId.of("Europe/Prague")));
            dbUser.setTs(LocalDateTime.now());
            if (getTwitchUser(dbUser.getId()) == null) {
                createTwitchUser(dbUser);
            } else {
                updateTwitchUser(dbUser);
            }
        });
    }

}

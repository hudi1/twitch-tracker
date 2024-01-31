package org.tomass.twitch.twitchtracker.task;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tomass.twitch.twitchtracker.service.TwitchUserService;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.helix.domain.StreamList;
import com.github.twitch4j.helix.domain.UserList;

@Component
public class TwitchUserTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TwitchClient twitchClient;
    @Autowired
    private TwitchUserService twitchUserService;

    @Scheduled(cron = "0 5/10 * * * *")
    public void trackUsers() {
        logger.debug(">> trackUsers");
        StreamList resultList = twitchClient.getHelix()
                .getStreams(null, null, null, 100, null, List.of("cs"), null, null).execute();
        List<String> userId = resultList.getStreams().stream().map(s -> s.getUserId()).collect(Collectors.toList());
        UserList twitchUsers = twitchClient.getHelix().getUsers(null, userId, null).execute();
        twitchUserService.createUsers(twitchUsers);
        resultList = twitchClient.getHelix().getStreams(null, null, null, 100, null, List.of("sk"), null, null)
                .execute();
        userId = resultList.getStreams().stream().map(s -> s.getUserId()).collect(Collectors.toList());
        twitchUsers = twitchClient.getHelix().getUsers(null, userId, null).execute();
        twitchUserService.createUsers(twitchUsers);
        logger.debug("<< trackUsers");
    }
}

package org.tomass.twitch.twitch.tracker.task;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tomass.twitch.model.TwitchUser;
import org.tomass.twitch.twitch.tracker.service.StreamService;
import org.tomass.twitch.twitch.tracker.service.TwitchUserService;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.helix.domain.StreamList;

import jakarta.annotation.PostConstruct;

@Component
public class TwitchStreamStatTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TwitchClient twitchClient;
    @Autowired
    private TwitchUserService twitchUserService;
    @Autowired
    private StreamService twitchStreamService;

    @Scheduled(cron = "* * 0 * * *")
    @PostConstruct
    public void statStreams() {
        logger.debug(">> statStreams");
        List<TwitchUser> users = twitchUserService.listTwitchUser();
        for (TwitchUser twitchUser : users) {
            twitchStreamService.getStreamData(twitchUser);
        }

        logger.debug("<< statStreams");
    }
}

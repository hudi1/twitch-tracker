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

@Component
public class TwitchStreamTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TwitchClient twitchClient;
    @Autowired
    private TwitchUserService twitchUserService;
    @Autowired
    private StreamService twitchStreamService;

    @Scheduled(cron = "0 */10 * * * *")
    public void trackStreams() {
        logger.debug(">> trackStreams");
        List<TwitchUser> users = twitchUserService.listTwitchUser();
        List<String> usersId = new ArrayList<>();
        int pocetStreamov = 0;
        for (TwitchUser twitchUser : users) {
            usersId.add(twitchUser.getId().toString());
            if (usersId.size() == 100) {
                StreamList resultList = twitchClient.getHelix()
                        .getStreams(null, null, null, usersId.size(), null, null, usersId, null).execute();
                twitchStreamService.createStreams(resultList);
                pocetStreamov = +resultList.getStreams().size();
                usersId.clear();
            }
        }
        if (usersId.size() > 0) {
            StreamList resultList = twitchClient.getHelix()
                    .getStreams(null, null, null, usersId.size(), null, null, usersId, null).execute();
            twitchStreamService.createStreams(resultList);
            pocetStreamov = +resultList.getStreams().size();
        }
        logger.info("Pocet online streamov: " + pocetStreamov);
        logger.debug("<< trackStreams");
    }
}

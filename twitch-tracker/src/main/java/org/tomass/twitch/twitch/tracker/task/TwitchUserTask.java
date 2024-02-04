package org.tomass.twitch.twitch.tracker.task;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tomass.twitch.twitch.tracker.service.TwitchUserService;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.helix.domain.StreamList;
import com.github.twitch4j.helix.domain.UserList;

import jakarta.annotation.PostConstruct;

@Component
public class TwitchUserTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TwitchClient twitchClient;
    @Autowired
    private TwitchUserService twitchUserService;

    @Scheduled(cron = "0 5/10 * * * *")
    @PostConstruct
    public void trackUsers() {
        logger.debug(">> trackUsers");
        String kurzor = null;
        do {
            kurzor = saveUsers(kurzor, "cs");
        } while (kurzor != null);
        do {
            saveUsers(kurzor, "sk");
        } while (kurzor != null);
        logger.debug("<< trackUsers");
    }

    private String saveUsers(String kurzor, String language) {
        StreamList resultList = twitchClient.getHelix()
                .getStreams(null, kurzor, null, 100, null, List.of(language), null, null).execute();
        if (!resultList.getStreams().isEmpty()) {
            List<String> usersId = resultList.getStreams().stream().map(s -> s.getUserId())
                    .collect(Collectors.toList());
            UserList twitchUsers = twitchClient.getHelix().getUsers(null, usersId, null).execute();
            twitchUserService.createUsers(twitchUsers);
            return resultList.getPagination().getCursor();
        }
        return null;
    }
}

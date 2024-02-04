package org.tomass.twitch.chat.tracker.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tomass.twitch.chat.tracker.service.TwitchUserService;
import org.tomass.twitch.model.TwitchUser;

import com.github.twitch4j.TwitchClient;

@Component
public class ChatLogTask {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TwitchClient twitchClient;

    @Autowired
    private TwitchUserService twitchUserService;

    @Scheduled(cron = "0 */10 * * * *")
    public void streamTask() {
        twitchUserService.listStreamUser(new TwitchUser()).stream().forEach(stream -> {
            if (!twitchClient.getChat().getChannels().contains(stream.getLogin())) {
                twitchClient.getChat().joinChannel(stream.getLogin());
            }
        });

        logger.info("Connected to " + twitchClient.getChat().getChannelNameToChannelId().size() + "/"
                + twitchClient.getChat().getChannels().size() + " channels");

    }
}

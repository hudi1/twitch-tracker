package org.tomass.twitch.twitch.tracker;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.web.WebApplicationInitializer;
import org.tomass.twitch.model.Stream;
import org.tomass.twitch.model.TwitchUser;
import org.tomass.twitch.twitch.tracker.config.AppConfig;
import org.tomass.twitch.twitch.tracker.config.CacheConfig;
import org.tomass.twitch.twitch.tracker.service.StreamService;
import org.tomass.twitch.twitch.tracker.service.TwitchUserService;
import org.tomass.twitch.twitch.tracker.task.TwitchStreamTask;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.events.ChannelChangeGameEvent;
import com.github.twitch4j.events.ChannelChangeTitleEvent;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import com.github.twitch4j.events.ChannelGoOfflineEvent;
import com.github.twitch4j.events.ChannelViewerCountUpdateEvent;
import com.github.twitch4j.helix.domain.User;

@SpringBootApplication
// @EnableScheduling
public class TwitchTrackerApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    private final TextEncryptor encryptor = Encryptors.delux("twitchtracker", "2024");

    @Autowired
    private CacheConfig cacheConfig;
    @Autowired
    private AppConfig config;
    @Autowired
    private TwitchUserService twitchUserService;
    @Autowired
    private StreamService streamService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(TwitchTrackerApplication.class).run(args);
    }

    @Bean
    public TwitchClient client() {
        TwitchClient client = TwitchClientBuilder.builder().withEnableHelix(true)
                .withClientId(config.getClientId())
                .withClientSecret(config.getSecretId()).build();
/*
        Collection<User> enabledEventUser = client.getClientHelper()
                .enableStreamEventListener(twitchUserService.listTwitchUser().stream().map(u -> u.getLogin()).toList());
        for (User user : enabledEventUser) {
            twitchUserService
                    .updateTwitchUser(new TwitchUser().withId(Long.parseLong(user.getId())).withEventEnabled(true));
        }

        client.getEventManager().onEvent(ChannelGoLiveEvent.class, event -> {
            cacheConfig.getLastStreamIdByUserId().put(Long.parseLong(event.getChannel().getId()), Long.parseLong(event.getStream().getId()));
            streamService.createStream(event.getStream());
        });

        client.getEventManager().onEvent(ChannelGoOfflineEvent.class, event -> {
            Long streamId = cacheConfig.getLastStreamIdByUserId().get(Long.parseLong(event.getChannel().getId()));
           if (streamId != null) {
                Stream dbStream = streamService.getStream(streamId);
                dbStream.setEndAt(LocalDateTime.now());
                streamService.updateStream(dbStream);
           }
        });
        
        client.getEventManager().onEvent(ChannelViewerCountUpdateEvent.class, event -> {
            streamService.createStreamData(event.getStream(), event.getFiredAtInstant());
        });
        
        client.getEventManager().onEvent(ChannelChangeTitleEvent.class, event -> {
            streamService.createStreamData(event.getStream(), event.getFiredAtInstant());
        });
        
        client.getEventManager().onEvent(ChannelChangeGameEvent.class, event -> {
            streamService.createStreamData(event.getStream(), event.getFiredAtInstant());
        });
        */
        return client;
    }

}

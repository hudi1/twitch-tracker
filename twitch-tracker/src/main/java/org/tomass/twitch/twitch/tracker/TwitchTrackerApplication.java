package org.tomass.twitch.twitch.tracker;

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
import org.tomass.twitch.model.TwitchUser;
import org.tomass.twitch.twitch.tracker.config.AppConfig;
import org.tomass.twitch.twitch.tracker.config.CacheConfig;
import org.tomass.twitch.twitch.tracker.service.TwitchUserService;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import com.github.twitch4j.events.ChannelGoOfflineEvent;
import com.github.twitch4j.helix.domain.Stream;
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

    public static void main(String[] args) {
        new SpringApplicationBuilder(TwitchTrackerApplication.class).run(args);
    }

    @Bean
    public TwitchClient client() {
        TwitchClient client = TwitchClientBuilder.builder().withEnableHelix(true)
                .withClientId(encryptor.decrypt(config.getClientId()))
                .withClientSecret(encryptor.decrypt(config.getSecretId())).build();

        Collection<User> enabledEventUser = client.getClientHelper()
                .enableStreamEventListener(twitchUserService.listTwitchUser().stream().map(u -> u.getLogin()).toList());
        for (User user : enabledEventUser) {
            twitchUserService
                    .updateTwitchUser(new TwitchUser().withId(Long.parseLong(user.getId())).withEventEnabled(true));
        }

        client.getEventManager().onEvent(ChannelGoLiveEvent.class, event -> {
            cacheConfig.getLastStreamByUserId().put(Long.parseLong(event.getChannel().getId()), event.getStream());
        });

        client.getEventManager().onEvent(ChannelGoOfflineEvent.class, event -> {
           Stream stream = cacheConfig.getLastStreamByUserId().get(Long.parseLong(event.getChannel().getId()));
           if (stream != null) {
               
           }
        });

        return client;
    }

}

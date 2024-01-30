package org.tomass.twitch.twitchtracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.WebApplicationInitializer;
import org.tomass.twitch.twitchtracker.config.AppConfig;
import org.tomass.twitch.twitchtracker.service.TwitchStreamService;
import org.tomass.twitch.twitchtracker.service.TwitchUserService;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.common.events.channel.ChannelGoLiveEvent;
import com.github.twitch4j.events.ChannelClipCreatedEvent;
import com.github.twitch4j.helix.domain.StreamList;
import com.github.twitch4j.helix.domain.UserList;

@SpringBootApplication
@EnableScheduling
public class TwitchtrackerApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Autowired
    private AppConfig config;
    @Autowired
    private TwitchUserService twitchUserService;
    @Autowired
    private TwitchStreamService twitchStreamService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(TwitchtrackerApplication.class).run(args);
    }

    @Bean
    public TwitchClient initUsers() {
        TwitchClient twitchClient = TwitchClientBuilder.builder().withEnableHelix(true)
                .withClientId(config.getClientId()).withClientSecret(config.getSecretId()).build();
        /*twitchClient.getClientHelper().enableClipEventListener("hudi1");
        

        twitchClient.getEventManager().onEvent(ChannelClipCreatedEvent.class, event -> {
            System.out.println(event.getClip());
        });*/


        /*
         * List<String> users = new ArrayList<>();
         * 
         * System.out.println(LocalDateTime.now()); StreamList resultList = twitchClient.getHelix() .getStreams(null,
         * null, null, 100, null, List.of("cs"), null, null).execute(); twitchStreamService.createStreams(resultList);
         * resultList.getStreams().forEach(user -> { users.add(user.getUserId()); });
         * 
         * System.out.println(LocalDateTime.now()); UserList twitchUsers = twitchClient.getHelix().getUsers(null, users,
         * null).execute(); twitchUserService.createUsers(twitchUsers); System.out.println(LocalDateTime.now());
         * 
         * users.clear(); resultList = twitchClient.getHelix().getStreams(null, null, null, 100, null, List.of("sk"),
         * null, null) .execute(); twitchStreamService.createStreams(resultList);
         * 
         * resultList.getStreams().forEach(user -> { users.add(user.getUserId()); }); twitchUsers =
         * twitchClient.getHelix().getUsers(null, users, null).execute(); twitchUserService.createUsers(twitchUsers);
         * System.out.println(LocalDateTime.now());
         * 
         * System.out.println("Users count " + twitchUserService.listTwitchUser().size());
         */
        return twitchClient;
    }

}

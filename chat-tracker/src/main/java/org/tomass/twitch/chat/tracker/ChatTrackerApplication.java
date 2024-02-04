package org.tomass.twitch.chat.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.WebApplicationInitializer;
import org.tomass.twitch.chat.tracker.config.AppConfig;
import org.tomass.twitch.chat.tracker.service.ChatlogService;
import org.tomass.twitch.chat.tracker.service.TwitchUserService;
import org.tomass.twitch.model.TwitchUser;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.IRCMessageEvent;

@SpringBootApplication
@EnableScheduling
public class ChatTrackerApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TwitchUserService twitchUserService;

    @Autowired
    private ChatlogService chatlogService;

    @Autowired
    private AppConfig appConfig;

    public static void main(String[] args) {
        new SpringApplicationBuilder(ChatTrackerApplication.class).run(args);
    }

    @Bean
    public TwitchClient initUsers() {
        TwitchClient twitchClient = TwitchClientBuilder.builder().withEnableChat(true).build();

        twitchClient.getEventManager().onEvent(IRCMessageEvent.class, event -> {
            if (appConfig.isSpoustetChatLog()) {
                if (event.getMessage().isPresent() && event.getCommandType().equals("PRIVMSG")) {
                    try {
                        chatlogService.ulozChatlog(event);
                    } catch (Exception e) {
                        logger.error("Event: " + event);
                        logger.error("!!DB:", e);
                    }
                }
            }
        });

        twitchUserService.listStreamUser(new TwitchUser()).stream().forEach(stream -> {
            twitchClient.getChat().joinChannel(stream.getLogin());
        });

        logger.info("Connected to " + +twitchClient.getChat().getChannels().size() + " channels");
        return twitchClient;
    }

}

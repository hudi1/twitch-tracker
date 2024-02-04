package org.tomass.twitch.twitch.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.web.WebApplicationInitializer;
import org.tomass.twitch.twitch.tracker.config.AppConfig;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;

@SpringBootApplication
//@EnableScheduling
public class TwitchTrackerApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    private final TextEncryptor encryptor = Encryptors.delux("twitchtracker", "2024");

    @Autowired
    private AppConfig config;

    public static void main(String[] args) {
        new SpringApplicationBuilder(TwitchTrackerApplication.class).run(args);
    }

    @Bean
    public TwitchClient initUsers() {
        return TwitchClientBuilder.builder().withEnableHelix(true).withClientId(encryptor.decrypt(config.getClientId()))
                .withClientSecret(encryptor.decrypt(config.getSecretId())).build();
    }

}

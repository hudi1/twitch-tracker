package org.tomass.twitch.chat.tracker.config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Configuration
@ConfigurationProperties(prefix = "config")
@JsonIgnoreProperties({ "$$beanFactory" })
public class AppConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean spoustetChatLog;

    public boolean isSpoustetChatLog() {
        return spoustetChatLog;
    }

    public void setSpoustetChatLog(boolean spoustetChatLog) {
        this.spoustetChatLog = spoustetChatLog;
    }

    @Override
    public String toString() {
        return "AppConfig [spoustetChatLog=" + spoustetChatLog + "]";
    }

}

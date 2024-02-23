package org.tomass.twitch.twitch.tracker.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Configuration;

import com.github.twitch4j.helix.domain.Stream;

@Configuration
public class CacheConfig {

    private Map<Long, Stream> lastStreamByUserId;

    public CacheConfig() {
        lastStreamByUserId = new ConcurrentHashMap<>();
    }

    public Map<Long, Stream> getLastStreamByUserId() {
        return lastStreamByUserId;
    }

    public void setLastStreamByUserId(Map<Long, Stream> lastStreamByUserId) {
        this.lastStreamByUserId = lastStreamByUserId;
    }

    @Override
    public String toString() {
        return "CacheConfig [lastStreamByUserId=" + lastStreamByUserId + "]";
    }

}

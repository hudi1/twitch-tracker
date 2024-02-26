package org.tomass.twitch.twitch.tracker.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Configuration;

import com.github.twitch4j.helix.domain.Stream;

@Configuration
public class CacheConfig {

    private Map<Long, Long> lastStreamIdByUserId;

    public CacheConfig() {
        lastStreamIdByUserId = new ConcurrentHashMap<>();
    }

    public Map<Long, Long> getLastStreamIdByUserId() {
        return lastStreamIdByUserId;
    }

    public void setLastStreamIdByUserId(Map<Long, Long> lastStreamIdByUserId) {
        this.lastStreamIdByUserId = lastStreamIdByUserId;
    }

    @Override
    public String toString() {
        return "CacheConfig [lastStreamIdByUserId=" + lastStreamIdByUserId + "]";
    }

}

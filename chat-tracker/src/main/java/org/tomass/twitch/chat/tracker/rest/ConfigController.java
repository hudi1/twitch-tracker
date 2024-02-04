package org.tomass.twitch.chat.tracker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tomass.twitch.chat.tracker.config.AppConfig;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ConfigController {

    @Autowired
    private AppConfig appConfig;

    @GetMapping("/config")
    public AppConfig getConfig(HttpServletRequest request) {
        return appConfig;
    }

}

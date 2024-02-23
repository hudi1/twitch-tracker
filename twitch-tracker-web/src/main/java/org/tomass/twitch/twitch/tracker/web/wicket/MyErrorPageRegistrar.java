package org.tomass.twitch.twitch.tracker.web.wicket;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

public class MyErrorPageRegistrar implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(final ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notFound"));
        registry.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/unauthorized"));
        registry.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/unauthorized"));
    }
}
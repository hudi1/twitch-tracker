package org.tomass.twitch.twitch.tracker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tomass.twitch.model.Stream;
import org.tomass.twitch.twitch.tracker.service.StreamService;

@RestController
@RequestMapping("/api")
public class ChartController {

    @Autowired
    private StreamService streamService;

    @GetMapping("/stream/{gameId}")
    public Stream getChartData(@PathVariable("gameId") Long gameId) {
        return streamService.getStream(gameId);
    }

}
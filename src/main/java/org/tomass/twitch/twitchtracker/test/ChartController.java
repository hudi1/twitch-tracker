package org.tomass.twitch.twitchtracker.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tomass.twitch.twitchtracker.model.TwitchStream;
import org.tomass.twitch.twitchtracker.model.TwitchStreamData;
import org.tomass.twitch.twitchtracker.service.TwitchStreamService;

@RestController
@RequestMapping("/api/chart")
public class ChartController {

    @Autowired
    private TwitchStreamService twitchStreamService;

    @GetMapping("/data")
    public List<ChartData> getChartData() {
        TwitchStream stream = twitchStreamService.getTwitchStream(41796575320l);
        List<ChartData> result = new ArrayList<>();
        for (TwitchStreamData data : stream.getTwitchStreamDatas()) {
            result.add(new ChartData(data.getTs(), data.getViewerCount()));
        }

        return result;
    }
}

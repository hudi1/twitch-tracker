package org.tomass.twitch.twitchtracker.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController {

    @GetMapping("/graph")
    public String showGraph() {
        return "graph"; // This returns the name of the Thymeleaf template without the .html extension
    }
    
    @GetMapping("/graph1")
    public String showGraph1() {
        return "graph1";
    }
}

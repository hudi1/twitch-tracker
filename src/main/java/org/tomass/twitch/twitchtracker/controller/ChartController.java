package org.tomass.twitch.twitchtracker.controller;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/chart")
public class ChartController {

    // @GetMapping("/line")
    public void generateLineChart(HttpServletResponse response) throws IOException {
        // Create dataset
        XYSeries series = new XYSeries("Count vs Time");
        series.add(1, 10);
        series.add(2, 20);
        series.add(3, 15);
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart("Time vs Count Chart", "Time", "Count", dataset);

        // Customize chart
        chart.setBackgroundPaint(Color.white);

        // Save the chart as an image and send it to the response
        response.setContentType("image/png");
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 800, 600);
    }
}

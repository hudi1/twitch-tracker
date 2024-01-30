package org.tomass.twitch.twitchtracker.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChartData {

    private LocalDateTime time;
    private int count;

    public ChartData() {
        // Default constructor required for JSON serialization
    }

    public ChartData(LocalDateTime time, int count) {
        this.time = time;
        this.count = count;
    }

    public String getFormattedTime() {
        // Format LocalDateTime as a string (adjust the pattern as needed)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}

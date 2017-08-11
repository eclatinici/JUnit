package com.github.unit_testing.demo.alarm.coupled;

import com.github.unit_testing.demo.alarm.temperature.Temperature;
import com.github.unit_testing.demo.alarm.temperature.TemperatureUtil;

public class Alarm {
    private Temperature threshold;

    public Alarm(Temperature temperature) {
        this.threshold = temperature;
    }

    public void sendNotification(Temperature value) {
        if(TemperatureUtil.comparator.compare(threshold, value) < 0) {
            System.out.println("Temperature too high");
        }
    }
}

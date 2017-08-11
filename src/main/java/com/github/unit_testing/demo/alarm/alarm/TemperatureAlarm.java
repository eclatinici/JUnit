package com.github.unit_testing.demo.alarm.alarm;

import com.github.unit_testing.demo.alarm.device.OutputDevice;
import com.github.unit_testing.demo.alarm.temperature.Temperature;
import com.github.unit_testing.demo.alarm.temperature.TemperatureUtil;


public class TemperatureAlarm extends Alarm <Temperature> {

    private Temperature threshold;
    private OutputDevice outputDevice;

    public TemperatureAlarm(Temperature threshold, OutputDevice outputDevice) {
        this.threshold = threshold;
        this.outputDevice = outputDevice;
    }


    @Override
    public boolean shouldTrigger(Temperature value) {
        return TemperatureUtil.comparator.compare(threshold, value) < 0;
    }

    @Override
    public void writeToDevice(Temperature value) {
        outputDevice.write("Temperature " + value + " exceeded threshold of " + threshold);
    }
}

package com.github.unit_testing.demo.alarm.coupled;

import com.github.unit_testing.demo.alarm.temperature.Temperature;

import java.util.concurrent.ThreadLocalRandom;

public class Sensor {
    private Alarm alarm = new Alarm(new Temperature(20, Temperature.Unit.Celsius));

    public void updateReading() {
        Temperature value = getTemperatureFromSIO();
        alarm.sendNotification(value);
    }

    private Temperature getTemperatureFromSIO() {
        double value = ThreadLocalRandom.current().nextDouble() * 500;
        return new Temperature(value, Temperature.Unit.Kelvin);
    }
}

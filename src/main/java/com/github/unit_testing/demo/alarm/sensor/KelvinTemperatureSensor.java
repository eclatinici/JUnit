package com.github.unit_testing.demo.alarm.sensor;

import com.github.unit_testing.demo.alarm.temperature.Util;
import com.github.unit_testing.demo.alarm.temperature.Temperature;

import java.util.concurrent.ThreadLocalRandom;

public class KelvinTemperatureSensor extends Sensor<Temperature> {

    @Override
    public void updateReading() {
        double value = getTemperatureFromSIO();
        setReading(new Temperature(value, Temperature.Unit.Kelvin));
    }

    private double getTemperatureFromSIO() {
        /**
         * Suppose there is some logic for retrieving the temperature
         * I used a random variable
         */
        double value = ThreadLocalRandom.current().nextDouble() * 500;
        return Util.round(value, 1) ;
    }
}

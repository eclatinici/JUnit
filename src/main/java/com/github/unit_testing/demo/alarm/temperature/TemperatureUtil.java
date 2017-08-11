package com.github.unit_testing.demo.alarm.temperature;

import java.util.Comparator;

public class TemperatureUtil {

    public static Comparator<Temperature> comparator = Comparator.comparingDouble(TemperatureUtil::toKelvin);

    public static double toKelvin(Temperature temperature) {
        switch (temperature.getUnit()) {
            case Celsius:
                return celsiusToKelvin(temperature);
            case Kelvin:
                return temperature.getValue();
            case Fahrenheit:
                return fahrenheitToKelvin(temperature);
            default:
                throw new IllegalStateException("Undefined temperature" + temperature.getUnit());
        }
    }

    private static double fahrenheitToKelvin(Temperature temperature) {
        return (temperature.getValue() - 32) * 5/9 + 273.15;
    }

    private static double celsiusToKelvin(Temperature temperature) {
        return 273.15 + temperature.getValue();
    }
}

package com.github.unit_testing.demo.alarm;

import com.github.unit_testing.demo.alarm.alarm.Alarm;
import com.github.unit_testing.demo.alarm.alarm.TemperatureAlarm;
import com.github.unit_testing.demo.alarm.device.ConsoleOutputDevice;
import com.github.unit_testing.demo.alarm.sensor.KelvinTemperatureSensor;
import com.github.unit_testing.demo.alarm.sensor.Sensor;
import com.github.unit_testing.demo.alarm.temperature.Temperature;

public class Main {

    public static void main(String... xs) throws InterruptedException {
        Sensor<Temperature> temperatureSensor = new KelvinTemperatureSensor();

        ConsoleOutputDevice consoleDevice = new ConsoleOutputDevice();

        Temperature warnThreshold = new Temperature(70, Temperature.Unit.Celsius);
        Temperature criticalThreshold = new Temperature(120, Temperature.Unit.Celsius);
        Alarm<Temperature> warn = new TemperatureAlarm(warnThreshold, consoleDevice);
        Alarm<Temperature> critical = new TemperatureAlarm(criticalThreshold, consoleDevice);

        temperatureSensor.addObserver(warn);
        temperatureSensor.addObserver(critical);

        while (true) {
            temperatureSensor.updateReading();
            Thread.sleep(500);
        }

    }
}

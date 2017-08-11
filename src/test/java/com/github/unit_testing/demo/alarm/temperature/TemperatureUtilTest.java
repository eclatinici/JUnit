package com.github.unit_testing.demo.alarm.temperature;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperatureUtilTest {

    @Test
    public void shouldConvertCelsiusToKelvin() {
        Temperature t = new Temperature(70, Temperature.Unit.Celsius);
        double expectedKelvinTemp = 343.15;

        assertEquals(TemperatureUtil.toKelvin(t), expectedKelvinTemp, 0.01);
    }

    @Test
    public void shouldConvertFahrenheitToKelvin() {
        Temperature t = new Temperature(100, Temperature.Unit.Fahrenheit);
        double expectedKelvinTemp = 310.93;

        assertEquals(TemperatureUtil.toKelvin(t), expectedKelvinTemp, 0.01);
    }

    @Test
    public void shouldNotChangeValue() {
        Temperature t = new Temperature(10, Temperature.Unit.Kelvin);
        double expectedKelvinTemp = 10;

        assertEquals(TemperatureUtil.toKelvin(t), expectedKelvinTemp, 0.01);
    }
}
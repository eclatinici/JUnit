package com.github.unit_testing.demo.alarm.temperature;

public class Temperature  {
    public enum Unit {
        Celsius, Fahrenheit, Kelvin;
    }

    private double value;
    private Unit unit;

    public Temperature(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}

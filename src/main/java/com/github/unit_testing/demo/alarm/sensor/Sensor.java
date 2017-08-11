package com.github.unit_testing.demo.alarm.sensor;

import com.github.unit_testing.demo.alarm.alarm.Alarm;

import java.util.ArrayList;

/**
 * Subject
 */
public abstract class Sensor<T> {

    private T reading;
    private ArrayList<Alarm<T>> alarms = new ArrayList<>();

    public void addObserver(Alarm<T> alarm) {
        alarms.add(alarm);
    }

    public void removeObserver(Alarm alarm) {
        alarms.remove(alarm);
    }

    public T getReading() {
        return reading;
    }

    protected void setReading(T reading) {
        this.reading = reading;
        notifyObservers();
    }

    public abstract void updateReading();

    private void notifyObservers() {
        alarms.forEach(alarm -> alarm.update(getReading()));
    }
}

package com.github.unit_testing.demo.alarm.alarm;

/**
 * Observer
 */
public abstract class Alarm<T> {

    public void update(T value) {
        if(shouldTrigger(value)) {
            writeToDevice(value);
        }
    }

    public abstract boolean shouldTrigger(T value);

    public abstract void writeToDevice(T value);

}

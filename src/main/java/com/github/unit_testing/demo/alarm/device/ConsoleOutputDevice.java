package com.github.unit_testing.demo.alarm.device;

public class ConsoleOutputDevice implements OutputDevice {

    public void write(String message) {
        System.out.println(message);
    }
}

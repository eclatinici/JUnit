package com.github.unit_testing.demo.alarm.alarm;

import com.github.unit_testing.demo.alarm.device.ConsoleOutputDevice;
import com.github.unit_testing.demo.alarm.device.OutputDevice;
import com.github.unit_testing.demo.alarm.temperature.Temperature;
import org.junit.Test;
import org.mockito.Mockito;


public class TemperatureAlarmTest {

    @Test
    public void shouldTriggerAlarm() {
        Temperature threshold = new Temperature(20, Temperature.Unit.Celsius);
        OutputDevice device = Mockito.spy(new ConsoleOutputDevice());
        Alarm<Temperature> alarm = new TemperatureAlarm(threshold,device);
        alarm.update(new Temperature(40, Temperature.Unit.Celsius));
        Mockito.verify(device, Mockito.times(1)).write(Mockito.anyString());
    }
}
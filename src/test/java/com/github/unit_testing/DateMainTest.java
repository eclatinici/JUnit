package com.github.unit_testing;

import com.github.unit_testing.demo.date.DateProvider;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static com.github.unit_testing.demo.date.DateMain.convertToString;
import static org.junit.Assert.*;

public class DateMainTest {
    @Test
    public void shouldConvertToString() {
        StubDateProvider stub = new StubDateProvider();
        assertEquals("2017-07-28", convertToString(stub));
    }

    @Test
    public void shouldCallDateProviderDIY() {
        MockDateProvider mock = new MockDateProvider();
        assertEquals("2016-06-06", convertToString(mock));
        assertTrue(mock.counter == 1);
    }

    @Test
    public void shouldCallDateProviderMockito() {
        DateProvider mock = Mockito.mock(DateProvider.class);
        Mockito.when(mock.getDate()).thenReturn(LocalDate.of(2016,06,06));
        assertEquals("2016-06-06", convertToString(mock));
        Mockito.verify(mock, Mockito.times(1)).getDate();
    }

    class StubDateProvider extends DateProvider {

        @Override
        public LocalDate getDate() {
            return LocalDate.of(2017,07,28);
        }

    }

    class MockDateProvider extends DateProvider {
        int counter = 0;
        @Override
        public LocalDate getDate() {
            counter ++;
            return LocalDate.of(2017,06,06);
        }

    }
}
package com.daehosting.temperatureconversions;

import org.junit.Test;

import java.math.*;

import static org.junit.Assert.*;

/**
 * Created by netherskub on 10/7/16.
 */
public class TemperatureConversionsTest {
    @Test
    public void testCelsiusToFahrenheit() throws Exception {
        TemperatureConversionsSoapType service =
                new TemperatureConversions().getTemperatureConversionsSoap12();
        BigDecimal celsiusToFahrenheitResult = service.celsiusToFahrenheit(BigDecimal.valueOf(0.0));
        assertEquals("The celcius to fahrenheit conversion failed",
                celsiusToFahrenheitResult, BigDecimal.valueOf(32));
    }

    @Test
    public void testFahrenheitToCelsius() throws Exception {
        TemperatureConversionsSoapType service =
                new TemperatureConversions().getTemperatureConversionsSoap12();
        BigDecimal fahrenheitToCelsiusResult = service.fahrenheitToCelsius(BigDecimal.valueOf(104.0));
        assertEquals("The Fahrenheit to Celsius conversion failed",
                fahrenheitToCelsiusResult, BigDecimal.valueOf(40));
    }

    @Test
    public void testFahrenheitWindChill() throws Exception {
        TemperatureConversionsSoapType service =
                new TemperatureConversions().getTemperatureConversionsSoap12();
        BigDecimal windChill = service.windChillInFahrenheit(BigDecimal.valueOf(75.0), BigDecimal.valueOf(10.0));
        windChill = windChill.setScale(2, RoundingMode.CEILING);
        assertEquals("The windchill in fahrenheit conversion failed",
                windChill, BigDecimal.valueOf(65.95));
    }

    @Test
    public void testCelsiusWindChill() throws Exception {
        TemperatureConversionsSoapType service =
                new TemperatureConversions().getTemperatureConversionsSoap12();
        BigDecimal windChill = service.windChillInCelsius(BigDecimal.valueOf(30.0), BigDecimal.valueOf(10.0));
        windChill = windChill.setScale(2, RoundingMode.CEILING);
        assertEquals("The windchill in fahrenheit conversion failed",
                windChill, BigDecimal.valueOf(25.98));
    }

}
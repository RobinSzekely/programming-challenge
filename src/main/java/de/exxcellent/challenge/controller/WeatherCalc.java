package de.exxcellent.challenge.controller;

import de.exxcellent.challenge.models.Weather;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * This class summarizes all calculation methods or analyses for a collection of Weather objects
 */
public class WeatherCalc {
    private final static Logger LOGGER = Logger.getLogger(WeatherCalc.class.getName());

    /**
     * Returns the day of the Weather object in the list where the temperature spread is the smallest
     * @param weatherList an ArrayList of Weather objects
     * @return index in the list where the temperature spread is the smallest
     */
    public static int dayWithSmallestTemperatureSpread(ArrayList<Weather> weatherList) {
        try {
            ArrayList<Integer> allTemperatureSpreads = weatherList.stream().
                    map(weather -> weather.getMxt() - weather.getMnt()).
                    collect(Collectors.toCollection(ArrayList::new));
            int minIndex = allTemperatureSpreads.indexOf(Collections.min(allTemperatureSpreads));
            return weatherList.get(minIndex).getDay();
        } catch(NullPointerException e) {
            LOGGER.log(Level.SEVERE,"List of Weather objects is null pointer",e);
        }
        return -1;
    }
}

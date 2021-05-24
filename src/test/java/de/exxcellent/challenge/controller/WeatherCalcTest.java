package de.exxcellent.challenge.controller;

import de.exxcellent.challenge.consts.FilePath;
import de.exxcellent.challenge.enums.FileContext;
import de.exxcellent.challenge.models.FileObject;
import de.exxcellent.challenge.models.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class WeatherCalcTest {
    private final AppController appController = new AppController();
    private ArrayList<Weather> weatherList;

    @BeforeEach
    public void setUp() {
        ArrayList<FileObject> rows = appController.generateModelList(FilePath.WeatherPath, FileContext.WEATHER);
        weatherList = rows.stream().map(weather -> (Weather) weather).
                collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    @DisplayName("Test smallest temperature spread method for Weather list")
    public void smallestTemperatureSpreadTest() {
        int result = WeatherCalc.dayWithSmallestTemperatureSpread(weatherList);
        assertEquals(14, result);
    }
}
package de.exxcellent.challenge.controller;

import de.exxcellent.challenge.consts.FilePath;
import de.exxcellent.challenge.enums.FileContext;
import de.exxcellent.challenge.models.FileObject;
import de.exxcellent.challenge.models.Football;
import de.exxcellent.challenge.models.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {
    private AppController appController;

    @BeforeEach
    public void setUp() {
        appController = new AppController();
    }

    @Test
    @DisplayName("Test for summarizing read CSV in FileObject ArrayList")
    public void FileObjectArrayListTest() {
        ArrayList<FileObject> modelList = appController.generateModelList(FilePath.WeatherPath,
                FileContext.WEATHER);
        assertEquals(30,modelList.size());
    }

    @Test
    @DisplayName("Test ArrayList for cast to Weather objects and correct size")
    public void WeatherArrayListTest() {
        ArrayList<FileObject> modelList = appController.generateModelList(FilePath.WeatherPath,
                FileContext.WEATHER);
        /* cast ArrayList from FileObject to Weather objects */
        ArrayList<Weather> weatherList = modelList.stream().map(weather -> (Weather) weather).
                collect(Collectors.toCollection(ArrayList::new));
        assertEquals(30,weatherList.size());
        assertEquals(1,weatherList.get(0).getDay());
    }

    @Test
    @DisplayName("Test ArrayList for Football objects and correct size")
    public void FootballArrayListTest() {
        ArrayList<FileObject> modelList = appController.generateModelList(FilePath.FootballPath,
                FileContext.FOOTBALL);
        /* cast ArrayList from FileObject to Weather objects */
        ArrayList<Football> footballList = modelList.stream().map(football -> (Football) football).
                collect(Collectors.toCollection(ArrayList::new));
        assertEquals(20,footballList.size());
        assertEquals("Arsenal",footballList.get(0).getTeam());
    }
}
package de.exxcellent.challenge.controller;

import de.exxcellent.challenge.consts.FilePath;
import de.exxcellent.challenge.enums.FileContext;
import de.exxcellent.challenge.models.FileObject;
import de.exxcellent.challenge.models.Football;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FootballCalcTest {
    private AppController appController = new AppController();
    private ArrayList<Football> footballList;

    @BeforeEach
    public void setUp() {
        ArrayList<FileObject> rows = appController.generateModelList(FilePath.FootballPath, FileContext.FOOTBALL);
        footballList = rows.stream().map(football -> (Football) football).
                collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    @DisplayName("Test calculation of smallest goal spread of all Football teams")
    public void smallestGoalSpreadTest() {
        String result = FootballCalc.teamWithSmallestGoalSpread(footballList);
        assertEquals("Aston_Villa",result);
    }
}
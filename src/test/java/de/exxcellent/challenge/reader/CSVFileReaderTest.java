package de.exxcellent.challenge.reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVFileReaderTest {
    private Reader reader;

    @BeforeEach
    public void setUp() {
        reader = new CSVFileReader();
    }

    @Test
    @DisplayName("Test for Weather data reading")
    public void readWeatherDataTest() throws IOException {
        ArrayList<String[]> weatherRows = reader.readFile("src/main/resources/de/exxcellent/challenge/weather.csv",true);
        assertEquals(30,weatherRows.size());
        assertEquals("1",weatherRows.get(0)[0]);
    }
}
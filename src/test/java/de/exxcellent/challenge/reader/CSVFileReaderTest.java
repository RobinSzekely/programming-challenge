package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.consts.FilePath;
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
    @DisplayName("Test for empty file reading")
    public void readEmptyFileTest() throws IOException {
        ArrayList<String[]> weatherRows = reader.readFile(FilePath.EmptyFilePath,true);
        assertEquals(0,weatherRows.size());
    }

    @Test
    @DisplayName("Test for Weather data reading")
    public void readWeatherDataTest() throws IOException {
        ArrayList<String[]> weatherRows = reader.readFile(FilePath.WeatherPath,true);
        assertEquals(30,weatherRows.size());
        assertEquals("1",weatherRows.get(0)[0]);
    }
}
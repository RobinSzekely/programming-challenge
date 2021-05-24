package de.exxcellent.challenge.controller;

import de.exxcellent.challenge.enums.FileContext;
import de.exxcellent.challenge.models.FileObject;
import de.exxcellent.challenge.models.Football;
import de.exxcellent.challenge.models.Weather;
import de.exxcellent.challenge.reader.CSVFileReader;
import de.exxcellent.challenge.reader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AppController {
    private final static Logger LOGGER = Logger.getLogger(AppController.class.getName());

    /**
     * Utilizes CSV file reader to read a given CSV and convert it to
     * ArrayList of specified model type in enum fileContext
     * @param path given path to the file to read
     * @return ArrayList of model
     */
    public ArrayList<FileObject> generateModelList(String path, FileContext fileContext) {
        Reader reader = new CSVFileReader();
        try {
            ArrayList<String[]> contents = reader.readFile(path,true);
            switch(fileContext) {
                case FOOTBALL:
                    /* Construct minimal Football object for each read row */
                    return contents.stream().
                            map(football -> new Football(football[0],
                                    Integer.parseInt(football[5]),
                                    Integer.parseInt(football[6]))).
                            collect(Collectors.toCollection(ArrayList::new));
                case WEATHER:
                    /* Construct minimal Weather object for each read row */
                    return contents.stream().
                            map(weather -> new Weather(Integer.parseInt(weather[0]),
                                    Integer.parseInt(weather[1]),
                                    Integer.parseInt(weather[2]))).
                            collect(Collectors.toCollection(ArrayList::new));
                // new cases can be added here for new CSV/JSON/... files
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Unable to open file", e);
        } catch(NullPointerException e) {
            LOGGER.log(Level.SEVERE, "Path or FileContext points towards null", e);
        } catch(ArrayIndexOutOfBoundsException e) {
            LOGGER.log(Level.SEVERE, "CSV file may have irregular format (i.e. different number of columns)" +
                            " and cannot be casted into object",
                    e);
        }
        return null;
    }
}

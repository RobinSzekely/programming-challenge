package de.exxcellent.challenge.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * General implementation of the reader interface that explicitly reads CSV files
 */
public class CSVFileReader implements Reader {

    private final Logger LOGGER =  Logger.getLogger(CSVFileReader.class.getName());

    @Override
    public ArrayList<String[]> readFile(String path, boolean includesHeader) throws IOException {
        ArrayList<String[]> result = new ArrayList<>();
        BufferedReader bufRead;
        try {
            bufRead = new BufferedReader(new FileReader(path));
            String row;
            while ((row = bufRead.readLine()) != null) {
                String[] data = row.split(",");
                result.add(data);
            }
            bufRead.close();
            /* Remove header row if available */
            if(includesHeader && result.size() > 0) {
                result.remove(0);
            }
        } catch(FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File in specified path not found", e);
        } catch(NullPointerException e) {
            LOGGER.log(Level.SEVERE, "Specified path points towards null", e);
        }
        return result;
    }
}

package de.exxcellent.challenge.reader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Extendable file reader interface that can be implemented for different data types.
 */
public interface Reader {
    /**
     *
     * @param path given path to the file to read
     * @param includesHeader boolean value if given file contains a header row that should be removed
     * @return the contents of the file as an ArrayList of String arrays
     * @throws IOException if an I/O error occurs
     */
    ArrayList<String[]> readFile(String path, boolean includesHeader) throws IOException;
}

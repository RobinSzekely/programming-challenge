package de.exxcellent.challenge;

import de.exxcellent.challenge.consts.FilePath;
import de.exxcellent.challenge.controller.AppController;
import de.exxcellent.challenge.controller.WeatherCalc;
import de.exxcellent.challenge.enums.FileContext;
import de.exxcellent.challenge.models.FileObject;
import de.exxcellent.challenge.models.Weather;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        /* Use AppController instance to create ArrayList of Weather objects */
        AppController controller = new AppController();
        ArrayList<FileObject> fileObjectList = controller.generateModelList(FilePath.WeatherPath,
                FileContext.WEATHER);
        ArrayList<Weather> weatherList = fileObjectList.stream().map(weather -> (Weather) weather).
                collect(Collectors.toCollection(ArrayList::new));

        /* Output for Weather objects */
        String dayWithSmallestTempSpread = ""+ WeatherCalc.dayWithSmallestTemperatureSpread(weatherList);
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}

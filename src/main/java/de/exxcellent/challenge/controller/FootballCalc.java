package de.exxcellent.challenge.controller;

import de.exxcellent.challenge.models.Football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * This class summarizes all calculation methods or analyses for a collection of Football objects
 */
public class FootballCalc {
    private final static Logger LOGGER = Logger.getLogger(FootballCalc.class.getName());

    /**
     * Returns the team name of the Football object in the list where the absolute difference between
     * goals and allowed goals is smallest
     * @param footballList an ArrayList of Football objects
     * @return team name of the Football team where the goal difference is minimal
     */
    public static String teamWithSmallestGoalSpread(ArrayList<Football> footballList) {
        try {
            ArrayList<Integer> allAbsoluteGoalDifferences = footballList.stream().
                    map(football -> Math.abs(football.getGoals()-football.getGoalsAllowed())).
                    collect(Collectors.toCollection(ArrayList::new));
            int minIndex = allAbsoluteGoalDifferences.indexOf(Collections.min(allAbsoluteGoalDifferences));
            return footballList.get(minIndex).getTeam();
        } catch(NullPointerException e) {
            LOGGER.log(Level.SEVERE,"List of Football objects is null pointer", e);
        }
        return null;
    }
}

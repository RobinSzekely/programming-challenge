package de.exxcellent.challenge.models;


/**
 * Represents a Football team in the English Premier League with their achieved results
 */
public class Football implements FileObject {
    private String team;
    private int games;
    private int wins;
    private int losses;
    private int draws;
    private int goals;
    private int goalsAllowed;
    private int points;

    /**
     * Constructs minimal Football object with three parameters required for the programming challenge
     * @param team name of Football team in the English Premier League
     * @param goals number of scored goals
     * @param goalsAllowed number of allowed goals
     */
    public Football(String team, int goals, int goalsAllowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(int goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return team + "," + games + "," + wins + "," + losses + "," + draws + "," +
                + goals + "," + goalsAllowed + "," + points;
    }
}
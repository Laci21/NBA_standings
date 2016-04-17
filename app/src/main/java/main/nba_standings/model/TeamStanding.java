package main.nba_standings.model;

/**
 * Created by Lac on 2016.04.17..
 */
public class TeamStanding {
    private int rank;
    private String teamName;
    private int wins;
    private int losses;

    public TeamStanding() {
    }

    public TeamStanding(int rank, String teamName, int wins, int losses) {
        this.rank = rank;
        this.teamName = teamName;
        this.wins = wins;
        this.losses = losses;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
}

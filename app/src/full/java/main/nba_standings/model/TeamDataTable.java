package main.nba_standings.model;

import com.orm.SugarRecord;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class TeamDataTable extends SugarRecord{
    private int rank;
    private String teamName;
    private int wins;
    private int losses;
    private String conference;
    private String division;
    private String arenaName;
    private String city;
    private String state;
    private boolean isFavouriteTeam;

    public TeamDataTable(){
    }

    public TeamDataTable(int rank, String teamName, int wins, int losses, String conference, String division, String arenaName, String city, String state, boolean isFavouriteTeam) {
        this.rank = rank;
        this.teamName = teamName;
        this.wins = wins;
        this.losses = losses;
        this.conference = conference;
        this.division = division;
        this.arenaName = arenaName;
        this.city = city;
        this.state = state;
        this.isFavouriteTeam = isFavouriteTeam;
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

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isFavouriteTeam() {
        return isFavouriteTeam;
    }

    public void setIsFavouriteTeam(boolean isFavouriteTeam) {
        this.isFavouriteTeam = isFavouriteTeam;
    }
}

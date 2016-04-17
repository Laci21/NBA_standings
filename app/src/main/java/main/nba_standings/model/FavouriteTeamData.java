package main.nba_standings.model;

/**
 * Created by Lac on 2016.04.17..
 */
public class FavouriteTeamData {
    private String teamName;
    private String conference;
    private String division;
    private String arenaName;
    private String city;
    private String state;

    public FavouriteTeamData(String teamName, String conference, String division, String arenaName, String city, String state) {
        this.teamName = teamName;
        this.conference = conference;
        this.division = division;
        this.arenaName = arenaName;
        this.city = city;
        this.state = state;
    }

    public String getTeamName() {

        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
}

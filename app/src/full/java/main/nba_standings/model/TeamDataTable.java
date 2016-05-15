package main.nba_standings.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.Objects;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class TeamDataTable extends SugarRecord {
    @SerializedName("rank")
    private int rank;

    @SerializedName("teamName")
    private String teamName;

    @SerializedName("wins")
    private int wins;

    @SerializedName("losses")
    private int losses;

    @SerializedName("conference")
    private String conference;

    @SerializedName("division")
    private String division;

    @SerializedName("arenaName")
    private String arenaName;

    @SerializedName("city")
    private String city;

    @SerializedName("state")
    private String state;

    @SerializedName("isFavouriteTeam")
    private boolean isFavouriteTeam;

    public TeamDataTable() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TeamDataTable teamDataTable = (TeamDataTable) o;
        return Objects.equals(rank, teamDataTable.rank) &&
                Objects.equals(teamName, teamDataTable.teamName) &&
                Objects.equals(wins, teamDataTable.wins) &&
                Objects.equals(losses, teamDataTable.losses) &&
                Objects.equals(conference, teamDataTable.conference) &&
                Objects.equals(division, teamDataTable.division) &&
                Objects.equals(arenaName, teamDataTable.arenaName) &&
                Objects.equals(city, teamDataTable.city) &&
                Objects.equals(state, teamDataTable.state) &&
                Objects.equals(isFavouriteTeam, teamDataTable.isFavouriteTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, teamName, wins, losses, conference, division, arenaName, city, state, isFavouriteTeam);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TeamDataTable {\n");

        sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
        sb.append("    teamName: ").append(toIndentedString(teamName)).append("\n");
        sb.append("    wins: ").append(toIndentedString(wins)).append("\n");
        sb.append("    losses: ").append(toIndentedString(losses)).append("\n");
        sb.append("    conference: ").append(toIndentedString(conference)).append("\n");
        sb.append("    division: ").append(toIndentedString(division)).append("\n");
        sb.append("    arenaName: ").append(toIndentedString(arenaName)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    isFavouriteTeam: ").append(toIndentedString(isFavouriteTeam)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

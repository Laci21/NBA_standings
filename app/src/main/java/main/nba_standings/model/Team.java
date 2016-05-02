package main.nba_standings.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Team   {
  
  @SerializedName("rank")
  private Long rank = null;
  
  @SerializedName("teamName")
  private String teamName = null;
  
  @SerializedName("wins")
  private Long wins = null;
  
  @SerializedName("losses")
  private Long losses = null;
  
  @SerializedName("conference")
  private String conference = null;
  
  @SerializedName("division")
  private String division = null;
  
  @SerializedName("arenaName")
  private String arenaName = null;
  
  @SerializedName("city")
  private String city = null;
  
  @SerializedName("state")
  private String state = null;
  
  @SerializedName("isFavouriteTeam")
  private Boolean isFavouriteTeam = null;
  

  
  /**
   **/
  public Long getRank() {
    return rank;
  }
  public void setRank(Long rank) {
    this.rank = rank;
  }

  
  /**
   **/
  public String getTeamName() {
    return teamName;
  }
  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  
  /**
   **/
  public Long getWins() {
    return wins;
  }
  public void setWins(Long wins) {
    this.wins = wins;
  }

  
  /**
   **/
  public Long getLosses() {
    return losses;
  }
  public void setLosses(Long losses) {
    this.losses = losses;
  }

  
  /**
   **/
  public String getConference() {
    return conference;
  }
  public void setConference(String conference) {
    this.conference = conference;
  }

  
  /**
   **/
  public String getDivision() {
    return division;
  }
  public void setDivision(String division) {
    this.division = division;
  }

  
  /**
   **/
  public String getArenaName() {
    return arenaName;
  }
  public void setArenaName(String arenaName) {
    this.arenaName = arenaName;
  }

  
  /**
   **/
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }

  
  /**
   **/
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  
  /**
   **/
  public Boolean getIsFavouriteTeam() {
    return isFavouriteTeam;
  }
  public void setIsFavouriteTeam(Boolean isFavouriteTeam) {
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
    Team team = (Team) o;
    return Objects.equals(rank, team.rank) &&
        Objects.equals(teamName, team.teamName) &&
        Objects.equals(wins, team.wins) &&
        Objects.equals(losses, team.losses) &&
        Objects.equals(conference, team.conference) &&
        Objects.equals(division, team.division) &&
        Objects.equals(arenaName, team.arenaName) &&
        Objects.equals(city, team.city) &&
        Objects.equals(state, team.state) &&
        Objects.equals(isFavouriteTeam, team.isFavouriteTeam);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank, teamName, wins, losses, conference, division, arenaName, city, state, isFavouriteTeam);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Team {\n");
    
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

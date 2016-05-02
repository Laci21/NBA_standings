package main.nba_standings.network;

import java.util.List;

import main.nba_standings.model.Team;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface NBAStandingsApi {
  
  /**
   * 
   * Return all teams from DB.
   * @return Call<List<Team>>
   */
  
  @GET("teams")
  Call<List<Team>> teamsGet();
    

  
  /**
   * 
   * Updates a team in DB.
   * @param team Team to update in DB.
   * @return Call<Team>
   */
  
  @PUT("teams")
  Call<Team> teamsPut(
          @Body Team team
  );

  
  /**
   * 
   * Creates a new team in DB.
   * @param team Team to add to DB.
   * @return Call<Team>
   */
  
  @POST("teams")
  Call<Team> teamsPost(
          @Body Team team
  );

  
  /**
   * 
   * Returns the team with the given name from DB.
   * @param teamName name of team to fetch
   * @return Call<Team>
   */
  
  @GET("teams/{teamName}")
  Call<Team> teamsTeamNameGet(
          @Path("teamName") String teamName
  );

  
  /**
   * 
   * Deletes a single team based on the name supplied
   * @param teamName name of team to delete
   * @return Call<Void>
   */
  
  @DELETE("teams/{teamName}")
  Call<Void> teamsTeamNameDelete(
          @Path("teamName") String teamName
  );

  
}

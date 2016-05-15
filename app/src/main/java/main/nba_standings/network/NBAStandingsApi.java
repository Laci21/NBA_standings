package main.nba_standings.network;

import java.util.List;

import main.nba_standings.model.TeamDataTable;
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
   * @return Call<List<TeamDataTable>>
   */
  
  @GET("teams")
  Call<List<TeamDataTable>> teamsGet();
    

  
  /**
   * 
   * Updates a team in DB.
   * @param teamDataTable TeamDataTable to update in DB.
   * @return Call<TeamDataTable>
   */
  
  @PUT("teams")
  Call<TeamDataTable> teamsPut(
          @Body TeamDataTable teamDataTable
  );

  
  /**
   * 
   * Creates a new team in DB.
   * @param teamDataTable TeamDataTable to add to DB.
   * @return Call<TeamDataTable>
   */
  
  @POST("teams")
  Call<TeamDataTable> teamsPost(
          @Body TeamDataTable teamDataTable
  );

  
  /**
   * 
   * Returns the team with the given name from DB.
   * @param teamName name of team to fetch
   * @return Call<TeamDataTable>
   */
  
  @GET("teams/{teamName}")
  Call<TeamDataTable> teamsTeamNameGet(
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

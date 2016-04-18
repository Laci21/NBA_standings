package main.nba_standings.interactor.favourite_details;

import java.util.ArrayList;
import java.util.List;

import main.nba_standings.model.FavouriteTeamData;
import main.nba_standings.model.TeamDataTable;
import main.nba_standings.model.TeamStanding;

public class FavouriteDetailsInteractor {
    public FavouriteDetailsInteractor() {
    }

    public FavouriteTeamData getTeamData(String favouriteTeamName) {
        List<TeamDataTable> favouriteTeamDataTableList = TeamDataTable.findWithQuery(TeamDataTable.class, "Select * from TeamDataTable where team_name = ?", favouriteTeamName);
        TeamDataTable favouriteTeamDataTable = favouriteTeamDataTableList.get(0);

        FavouriteTeamData favouriteTeamData = new FavouriteTeamData(favouriteTeamDataTable.getTeamName(), favouriteTeamDataTable.getConference(), favouriteTeamDataTable.getDivision(), favouriteTeamDataTable.getArenaName(), favouriteTeamDataTable.getCity(), favouriteTeamDataTable.getState());

        //TODO: delete these
        if (favouriteTeamName == null) {
            favouriteTeamData = new FavouriteTeamData("", "", "", "", "", "");
        } else {
            favouriteTeamData = new FavouriteTeamData("Atlanta Hawks", "East", "Southeast", "Philips Arena", "Atlanta", "Georgia");
        }

        return favouriteTeamData;
    }
}
package main.nba_standings.interactor.favourite_details;

import java.util.List;

import main.nba_standings.model.FavouriteTeamData;
import main.nba_standings.model.TeamDataTable;

public class FavouriteDetailsInteractor {
    public FavouriteDetailsInteractor() {
    }

    public FavouriteTeamData getTeamData(String favouriteTeamName) {
        FavouriteTeamData favouriteTeamData = null;
        if (favouriteTeamName != null) {
            List<TeamDataTable> favouriteTeamDataTableList = TeamDataTable.find(TeamDataTable.class, "team_name = ?", favouriteTeamName);
            TeamDataTable favouriteTeamDataTable = null;
            if (favouriteTeamDataTableList != null && !favouriteTeamDataTableList.isEmpty()) {
                favouriteTeamDataTable = favouriteTeamDataTableList.get(0);
            }

            if (favouriteTeamDataTable != null) {
                favouriteTeamData = new FavouriteTeamData(favouriteTeamDataTable.getTeamName(),
                        favouriteTeamDataTable.getConference(),
                        favouriteTeamDataTable.getDivision(),
                        favouriteTeamDataTable.getArenaName(),
                        favouriteTeamDataTable.getCity(),
                        favouriteTeamDataTable.getState());
            }

            //TODO: delete these
            favouriteTeamData = new FavouriteTeamData("Atlanta Hawks", "East", "Southeast", "Philips Arena", "Atlanta", "Georgia");

        } else {
            favouriteTeamData = new FavouriteTeamData("", "", "", "", "", "");
        }

        return favouriteTeamData;
    }
}
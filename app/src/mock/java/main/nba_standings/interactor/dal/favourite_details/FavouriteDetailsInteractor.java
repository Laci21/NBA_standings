package main.nba_standings.interactor.dal.favourite_details;

import main.nba_standings.interactor.dal.TeamDataTableMockStore;
import main.nba_standings.model.FavouriteTeamData;
import main.nba_standings.model.TeamDataTable;

public class FavouriteDetailsInteractor {
    private TeamDataTableMockStore teamDataTableMockStore;

    public FavouriteDetailsInteractor() {
        teamDataTableMockStore = new TeamDataTableMockStore();
    }

    public FavouriteTeamData getTeamData(String favouriteTeamName) {
        FavouriteTeamData favouriteTeamData = null;
        if (favouriteTeamName != null) {
            TeamDataTable favouriteTeamDataTable = teamDataTableMockStore.getTeamDataTableMap().get(favouriteTeamName);

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
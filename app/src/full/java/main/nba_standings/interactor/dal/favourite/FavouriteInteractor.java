package main.nba_standings.interactor.dal.favourite;

import java.util.ArrayList;
import java.util.List;

import main.nba_standings.model.TeamDataTable;

public class FavouriteInteractor {
    public FavouriteInteractor() {
    }

    public ArrayList<String> getTeamNames() {
        List<TeamDataTable> teamDataTableList = TeamDataTable.find(TeamDataTable.class, null, null, null, "team_name", null);

        ArrayList<String> teamNames = new ArrayList<String>();

        for(TeamDataTable teamDataTable : teamDataTableList){
            teamNames.add(teamDataTable.getTeamName());
        }

        return teamNames;
    }
}
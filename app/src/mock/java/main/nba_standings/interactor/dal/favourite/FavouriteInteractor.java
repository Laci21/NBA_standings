package main.nba_standings.interactor.dal.favourite;

import java.util.ArrayList;

import main.nba_standings.interactor.dal.TeamDataTableMockStore;
import main.nba_standings.model.TeamDataTable;

public class FavouriteInteractor {
    private TeamDataTableMockStore teamDataTableMockStore;
    public FavouriteInteractor() {
        teamDataTableMockStore = new TeamDataTableMockStore();
    }

    public ArrayList<String> getTeamNames() {
        //TODO: order by teamName
        ArrayList<String> teamNames = new ArrayList<String>();

        for(TeamDataTable teamDataTable : teamDataTableMockStore.getTeamDataTableMap().values()){
            teamNames.add(teamDataTable.getTeamName());
        }

        //TODO: delete these
        String[] teams = new String[]{"Cleveland Cavaliers", "San Antonio", "..."};

        for(int i = 0; i < teams.length; i++){
            teamNames.add(teams[i]);
        }

        return teamNames;
    }
}
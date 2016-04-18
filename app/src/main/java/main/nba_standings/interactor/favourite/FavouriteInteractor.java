package main.nba_standings.interactor.favourite;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;

import main.nba_standings.model.TeamDataTable;
import main.nba_standings.model.TeamStanding;

public class FavouriteInteractor {
    public FavouriteInteractor() {
    }

    public ArrayList<String> getTeamNames() {
        List<TeamDataTable> teamDataTableList = TeamDataTable.find(TeamDataTable.class, null, null, null, "team_name", null);

        ArrayList<String> teamNames = new ArrayList<String>();

        for(TeamDataTable teamDataTable : teamDataTableList){
            teamNames.add(teamDataTable.getTeamName());
        }

        //TODO: delete these
        String[] teams = new String[]{"Golden State", "San Antonio", "..."};

        for(int i = 0; i < teams.length; i++){
            teamNames.add(teams[i]);
        }

        return teamNames;
    }
}
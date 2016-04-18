package main.nba_standings.interactor.dal.favourite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import main.nba_standings.interactor.dal.TeamDataTableMockStore;
import main.nba_standings.model.TeamDataTable;

public class FavouriteInteractor {
    private TeamDataTableMockStore teamDataTableMockStore = TeamDataTableMockStore.getInstance();
    public FavouriteInteractor() {
    }

    public ArrayList<String> getTeamNames() {
        List<TeamDataTable> teamDataTableList = new ArrayList<TeamDataTable>(teamDataTableMockStore.getTeamDataTableMap().values());
        Collections.sort(teamDataTableList, new MyTeamNameComparator());

        ArrayList<String> teamNames = new ArrayList<String>();
        for(TeamDataTable teamDataTable : teamDataTableList){
            teamNames.add(teamDataTable.getTeamName());
        }

        return teamNames;
    }

    public class MyTeamNameComparator implements Comparator<TeamDataTable> {
        @Override
        public int compare(TeamDataTable o1, TeamDataTable o2) {
            return (o1.getTeamName().compareTo(o2.getTeamName()));
        }
    }
}
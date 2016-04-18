package main.nba_standings.interactor.dal.standings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import main.nba_standings.interactor.dal.TeamDataTableMockStore;
import main.nba_standings.model.TeamDataTable;
import main.nba_standings.model.TeamStanding;

public class StandingsInteractor {
    private TeamDataTableMockStore teamDataTableMockStore = TeamDataTableMockStore.getInstance();

    public StandingsInteractor() {
    }

    public ArrayList<TeamStanding> getStandings() {
        List<TeamDataTable> teamDataTableList = new ArrayList<TeamDataTable>(teamDataTableMockStore.getTeamDataTableMap().values());
        Collections.sort(teamDataTableList, new MyRankComparator());

        ArrayList<TeamStanding> teamStandingList = new ArrayList<TeamStanding>();
        for (TeamDataTable teamDataTable : teamDataTableList) {
            teamStandingList.add(new TeamStanding(teamDataTable.getRank(), teamDataTable.getTeamName(), teamDataTable.getWins(), teamDataTable.getLosses()));
        }

        return teamStandingList;
    }

    public class MyRankComparator implements Comparator<TeamDataTable> {
        @Override
        public int compare(TeamDataTable o1, TeamDataTable o2) {
            return (o1.getRank() < o2.getRank() ? -1 : (o1.getRank() == o2.getRank() ? 0 : 1));
        }
    }
}
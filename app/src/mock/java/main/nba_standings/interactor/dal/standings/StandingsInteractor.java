package main.nba_standings.interactor.dal.standings;

import java.util.ArrayList;

import main.nba_standings.interactor.dal.TeamDataTableMockStore;
import main.nba_standings.model.TeamDataTable;
import main.nba_standings.model.TeamStanding;

public class StandingsInteractor {
    private TeamDataTableMockStore teamDataTableMockStore;
    public StandingsInteractor() {
        teamDataTableMockStore = new TeamDataTableMockStore();
    }

    public ArrayList<TeamStanding> getStandings() {
        //TODO: order by rank
        ArrayList<TeamStanding> teamStandingList = new ArrayList<TeamStanding>();

        for (TeamDataTable teamDataTable : teamDataTableMockStore.getTeamDataTableMap().values()) {
            teamStandingList.add(new TeamStanding(teamDataTable.getRank(), teamDataTable.getTeamName(), teamDataTable.getWins(), teamDataTable.getLosses()));
        }

        //TODO: delete these
        TeamStanding goldenState = new TeamStanding(1, "Golden State", 73, 9);
        TeamStanding sanAntonio = new TeamStanding(2, "San Antonio", 69, 13);

        teamStandingList.add(goldenState);
        teamStandingList.add(sanAntonio);

        return teamStandingList;
    }
}
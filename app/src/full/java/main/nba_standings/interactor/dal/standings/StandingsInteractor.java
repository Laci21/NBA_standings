package main.nba_standings.interactor.dal.standings;

import java.util.ArrayList;
import java.util.List;

import main.nba_standings.model.TeamDataTable;
import main.nba_standings.model.TeamStanding;

public class StandingsInteractor {
    public StandingsInteractor() {
    }

    public ArrayList<TeamStanding> getStandings() {
        List<TeamDataTable> teamDataTableList = TeamDataTable.find(TeamDataTable.class, null, null, null, "rank", null);

        ArrayList<TeamStanding> teamStandingList = new ArrayList<TeamStanding>();

        for (TeamDataTable teamDataTable : teamDataTableList) {
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
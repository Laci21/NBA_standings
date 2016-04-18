package main.nba_standings.interactor.standings;

import java.util.ArrayList;

import main.nba_standings.model.TeamStanding;

public class StandingsInteractor {
    public StandingsInteractor() {
    }

    public ArrayList<TeamStanding> getStandings() {
        //TODO: find out standindgs from DB
        ArrayList<TeamStanding> teamStandingList = new ArrayList<TeamStanding>();

        TeamStanding goldenState = new TeamStanding(1, "Golden State", 73, 9);
        TeamStanding sanAntonio = new TeamStanding(2, "San Antonio", 69, 13);

        teamStandingList.add(goldenState);
        teamStandingList.add(sanAntonio);

        return teamStandingList;
    }
}
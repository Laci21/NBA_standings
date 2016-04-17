package main.nba_standings.ui.standings;

import java.util.ArrayList;

import main.nba_standings.model.TeamStanding;
import main.nba_standings.ui.Presenter;

public class StandingsPresenter extends Presenter<StandingsScreen> {
    private static StandingsPresenter instance = null;

    private StandingsPresenter() {
    }

    public static StandingsPresenter getInstance() {
        if (instance == null) {
            instance = new StandingsPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(StandingsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showStandings(){
        //TODO: find out standindgs from DB

        ArrayList<TeamStanding> teamStandingList = new ArrayList<TeamStanding>();

        TeamStanding goldenState = new TeamStanding(1, "Golden State", 73, 9);
        TeamStanding sanAntonio = new TeamStanding(2, "San Antonio", 69, 13);

        teamStandingList.add(goldenState);
        teamStandingList.add(sanAntonio);

        screen.showStandings(teamStandingList);
    }
}

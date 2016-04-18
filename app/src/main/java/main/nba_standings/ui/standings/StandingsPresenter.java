package main.nba_standings.ui.standings;

import java.util.ArrayList;

import javax.inject.Inject;

import main.nba_standings.NbaStandingsApplication;
import main.nba_standings.interactor.dal.standings.StandingsInteractor;
import main.nba_standings.model.TeamStanding;
import main.nba_standings.ui.Presenter;

public class StandingsPresenter extends Presenter<StandingsScreen> {
    private static StandingsPresenter instance = null;

    @Inject
    StandingsInteractor standingsInteractor;

    public static StandingsPresenter getInstance() {
        if (instance == null) {
            instance = new StandingsPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(StandingsScreen screen) {
        super.attachScreen(screen);
        NbaStandingsApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showStandings(){
        ArrayList<TeamStanding> teamStandingList = standingsInteractor.getStandings();

        screen.showStandings(teamStandingList);
    }
}

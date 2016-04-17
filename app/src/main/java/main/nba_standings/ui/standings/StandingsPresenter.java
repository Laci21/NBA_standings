package main.nba_standings.ui.standings;

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
        String[][] standings = null;
        screen.showStandings(standings);
    }
}

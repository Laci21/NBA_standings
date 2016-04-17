package main.nba_standings.ui.favourite;

import main.nba_standings.ui.Presenter;

public class FavouritePresenter extends Presenter<FavouriteScreen> {
    private static FavouritePresenter instance = null;

    private FavouritePresenter() {
    }

    public static FavouritePresenter getInstance() {
        if (instance == null) {
            instance = new FavouritePresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(FavouriteScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showTeamNames(){
        //TODO: get team names from DB
        String[] teamNames = null;
        screen.showTeamNames(teamNames);
    }
}

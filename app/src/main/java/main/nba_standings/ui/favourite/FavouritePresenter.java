package main.nba_standings.ui.favourite;

import java.util.ArrayList;

import javax.inject.Inject;

import main.nba_standings.NbaStandingsApplication;
import main.nba_standings.interactor.dal.favourite.FavouriteInteractor;
import main.nba_standings.ui.Presenter;

public class FavouritePresenter extends Presenter<FavouriteScreen> {
    private static FavouritePresenter instance = null;

    @Inject
    FavouriteInteractor favouriteInteractor;

    public static FavouritePresenter getInstance() {
        if (instance == null) {
            instance = new FavouritePresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(FavouriteScreen screen) {
        super.attachScreen(screen);
        NbaStandingsApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showTeamNames(){
        ArrayList<String> teamNames = favouriteInteractor.getTeamNames();

        screen.showTeamNames(teamNames);
    }
}

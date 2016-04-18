package main.nba_standings.ui.favourite_details;

import javax.inject.Inject;

import main.nba_standings.NbaStandingsApplication;
import main.nba_standings.interactor.dal.favourite_details.FavouriteDetailsInteractor;
import main.nba_standings.model.FavouriteTeamData;
import main.nba_standings.ui.Presenter;

public class FavouriteDetailsPresenter extends Presenter<FavouriteDetailsScreen> {
    private static FavouriteDetailsPresenter instance = null;

    public static String FAVOURITE_TEAM_NAME = null;

    @Inject
    FavouriteDetailsInteractor favouriteDetailsInteractor;

    public static FavouriteDetailsPresenter getInstance() {
        if (instance == null) {
            instance = new FavouriteDetailsPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(FavouriteDetailsScreen screen) {
        super.attachScreen(screen);
        NbaStandingsApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showTeamData(){
        FavouriteTeamData favouriteTeamData = favouriteDetailsInteractor.getTeamData(FAVOURITE_TEAM_NAME);

        screen.showTeamData(favouriteTeamData);
    }

    public void deleteFavouriteTeam() {
        FAVOURITE_TEAM_NAME = null;

        screen.showFavouriteFragment();
    }

    public void refreshTeamData(){
        screen.refreshTeamData();
    }
}

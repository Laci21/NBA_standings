package main.nba_standings.ui.favourite_details;

import main.nba_standings.ui.Presenter;

public class FavouriteDetailsPresenter extends Presenter<FavouriteDetailsScreen> {
    private static FavouriteDetailsPresenter instance = null;

    public static String FAVOURITE_TEAM_NAME = null;

    private FavouriteDetailsPresenter() {
    }

    public static FavouriteDetailsPresenter getInstance() {
        if (instance == null) {
            instance = new FavouriteDetailsPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(FavouriteDetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showTeamData(){
        //TODO: get team data from DB
        String[] teamData = null;
        screen.showTeamData(teamData);
    }

    public void deleteFavouriteTeam() {
        FAVOURITE_TEAM_NAME = null;

        screen.showFavouriteFragment();
    }
}

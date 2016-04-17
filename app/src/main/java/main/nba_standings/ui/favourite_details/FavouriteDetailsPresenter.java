package main.nba_standings.ui.favourite_details;

import main.nba_standings.model.FavouriteTeamData;
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

        FavouriteTeamData favouriteTeamData = null;
        if(FAVOURITE_TEAM_NAME == null){
            favouriteTeamData = new FavouriteTeamData("", "", "", "", "", "");
        }else {
             favouriteTeamData = new FavouriteTeamData("Atlanta Hawks", "East", "Southeast", "Philips Arena", "Atlanta", "Georgia");
        }

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

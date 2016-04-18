package main.nba_standings.interactor.favourite_details;

import java.util.ArrayList;

import main.nba_standings.model.FavouriteTeamData;

public class FavouriteDetailsInteractor {
    public FavouriteDetailsInteractor() {
    }

    public FavouriteTeamData getTeamData(String favouriteTeamName) {
        //TODO: get team data from DB
        FavouriteTeamData favouriteTeamData = null;
        if (favouriteTeamName == null) {
            favouriteTeamData = new FavouriteTeamData("", "", "", "", "", "");
        } else {
            favouriteTeamData = new FavouriteTeamData("Atlanta Hawks", "East", "Southeast", "Philips Arena", "Atlanta", "Georgia");
        }

        return favouriteTeamData;
    }
}
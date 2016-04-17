package main.nba_standings.ui.favourite_details;

import main.nba_standings.model.FavouriteTeamData;

public interface FavouriteDetailsScreen {
    void showTeamData(FavouriteTeamData favouriteTeamData);

    void showFavouriteFragment();

    void refreshTeamData();
}

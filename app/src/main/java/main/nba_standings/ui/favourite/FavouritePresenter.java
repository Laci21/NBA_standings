package main.nba_standings.ui.favourite;

import java.util.ArrayList;

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

        String[] teams = new String[]{"Golden State", "San Antonio", "..."};

        ArrayList<String> teamNames = new ArrayList<String>();
        for(int i = 0; i < teams.length; i++){
            teamNames.add(teams[i]);
        }

        screen.showTeamNames(teamNames);
    }
}

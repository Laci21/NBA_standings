package main.nba_standings.interactor.favourite;

import java.util.ArrayList;

public class FavouriteInteractor {
    public FavouriteInteractor() {
    }

    public ArrayList<String> getTeamNames() {
        //TODO: get team names from DB
        String[] teams = new String[]{"Golden State", "San Antonio", "..."};

        ArrayList<String> teamNames = new ArrayList<String>();
        for(int i = 0; i < teams.length; i++){
            teamNames.add(teams[i]);
        }

        return teamNames;
    }
}
package main.nba_standings.ui.standings;

import java.util.ArrayList;

import main.nba_standings.model.TeamStanding;

public interface StandingsScreen {
    void showStandings(ArrayList<TeamStanding> teamStandingList);
}
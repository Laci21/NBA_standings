package main.nba_standings.interactor.dal;

import java.util.HashMap;
import java.util.Map;

import main.nba_standings.model.TeamDataTable;

/**
 * Created by Lac on 2016.04.18..
 */
public class TeamDataTableMockStore {
    private static TeamDataTableMockStore teamDataTableMockStore = null;
    private Map<String, TeamDataTable> teamDataTableMap = new HashMap<String, TeamDataTable>();

    private TeamDataTableMockStore() {
    }

    public static TeamDataTableMockStore getInstance( ) {
        if(teamDataTableMockStore == null){
            teamDataTableMockStore = new TeamDataTableMockStore();
        }
        return teamDataTableMockStore;
    }

    public Map<String, TeamDataTable> getTeamDataTableMap() {
        return teamDataTableMap;
    }
}

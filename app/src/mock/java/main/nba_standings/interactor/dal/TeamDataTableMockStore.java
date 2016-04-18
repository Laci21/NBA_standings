package main.nba_standings.interactor.dal;

import java.util.HashMap;
import java.util.Map;

import main.nba_standings.model.TeamDataTable;

/**
 * Created by Lac on 2016.04.18..
 */
public class TeamDataTableMockStore {
    private static Map<String, TeamDataTable> teamDataTableMap;

    public TeamDataTableMockStore() {
        teamDataTableMap = new HashMap<String, TeamDataTable>();
    }

    public TeamDataTableMockStore(Map<String, TeamDataTable> teamDataTableMap) {
        this.teamDataTableMap = teamDataTableMap;
    }

    public Map<String, TeamDataTable> getTeamDataTableMap() {
        return teamDataTableMap;
    }

    public void setTeamDataTableMap(Map<String, TeamDataTable> teamDataTableMap) {
        this.teamDataTableMap = teamDataTableMap;
    }
}

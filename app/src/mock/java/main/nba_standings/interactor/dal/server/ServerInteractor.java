package main.nba_standings.interactor.dal.server;

import main.nba_standings.interactor.dal.TeamDataTableMockStore;
import main.nba_standings.model.TeamDataTable;

public class ServerInteractor {
    private TeamDataTableMockStore teamDataTableMockStore;
    public ServerInteractor() {
        teamDataTableMockStore = new TeamDataTableMockStore();
    }

    public TeamDataTable findTeam(String teamName) {
        return teamDataTableMockStore.getTeamDataTableMap().get(teamName);
    }

    public void saveTeam(TeamDataTable teamToSave) {
        teamDataTableMockStore.getTeamDataTableMap().put(teamToSave.getTeamName(), teamToSave);
    }

    public void updateTeam(TeamDataTable teamToUpdate) {
        saveTeam(teamToUpdate);
    }

    public void deleteTeam(String teamName) {
       teamDataTableMockStore.getTeamDataTableMap().remove(teamName);
    }
}
package main.nba_standings.interactor.dal.server;

import java.util.List;

import main.nba_standings.model.TeamDataTable;

public class ServerInteractor {
    public ServerInteractor() {
    }

    public TeamDataTable findTeam(String teamName) {
        List<TeamDataTable> teamDataTableList = TeamDataTable.find(TeamDataTable.class, "team_name = ?", teamName);
        if (teamDataTableList != null && !teamDataTableList.isEmpty()) {
            return teamDataTableList.get(0);
        }
        return null;
    }

    public void saveTeam(TeamDataTable teamToSave) {
        teamToSave.save();
    }

    public void updateTeam(TeamDataTable teamToUpdate) {
        deleteTeam(teamToUpdate.getTeamName());
        teamToUpdate.save();
    }

    public void deleteTeam(String teamName) {
        TeamDataTable teamDataTable = findTeam(teamName);
        if(teamDataTable != null){
            teamDataTable.delete();
        }
    }
}
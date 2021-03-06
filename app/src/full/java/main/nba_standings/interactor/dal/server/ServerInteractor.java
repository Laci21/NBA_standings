package main.nba_standings.interactor.dal.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.nba_standings.model.TeamDataTable;

public class ServerInteractor {
    public ServerInteractor() {
    }

    public List<TeamDataTable> findAllTeams() {
        List<TeamDataTable> teamDataTableList = new ArrayList<TeamDataTable>();
        Iterator<TeamDataTable> iterator = TeamDataTable.findAll(TeamDataTable.class);
        while (iterator.hasNext()) {
            teamDataTableList.add(iterator.next());
        }

        return teamDataTableList;
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

    public void flushDB() {
        List<TeamDataTable> teamDataTableList = TeamDataTable.listAll(TeamDataTable.class);
        TeamDataTable.deleteAll(TeamDataTable.class);
    }
}
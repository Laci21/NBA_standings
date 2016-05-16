package main.nba_standings;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.List;

import main.nba_standings.interactor.dal.server.ServerInteractor;
import main.nba_standings.model.TeamDataTable;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ServerUnitTest {

    private ServerInteractor serverInteractor;

    private String GSString;
    private String SAString;

    private TeamDataTable GSTeamDataTable;
    private TeamDataTable GSTeamDataTableWithConference;
    private TeamDataTable SATeamDataTable;

    @Before
    public void setup() throws Exception {
        serverInteractor = new ServerInteractor();

        GSString = "Golden State";
        SAString = "San Antonio";

        GSTeamDataTable = new TeamDataTable(1, GSString, 73, 9, "A", "A", "A", "A", "A", false);
        GSTeamDataTableWithConference = new TeamDataTable(1, GSString, 73, 9, "Western", "A", "A", "A", "A", false);
        SATeamDataTable = new TeamDataTable(2, "San Antonio", 69, 13, "B", "B", "B", "B", "B", false);
    }

    @Test
    public void saveAndFindTeam() throws IOException {
        serverInteractor.saveTeam(GSTeamDataTable);
        assertEquals(GSString, serverInteractor.findTeam(GSString).getTeamName());
    }

    @Test
    public void updateTeam() throws IOException {
        serverInteractor.saveTeam(GSTeamDataTable);
        serverInteractor.updateTeam(GSTeamDataTableWithConference);

        assertEquals("Western", serverInteractor.findTeam(GSString).getConference());
    }

    @Test
    public void deleteTeam() throws IOException {
        serverInteractor.saveTeam(GSTeamDataTable);
        serverInteractor.deleteTeam(GSString);

        assertNull(serverInteractor.findTeam(GSString));
    }

    @Test
    public void findAllTeams() throws IOException {
        serverInteractor.saveTeam(GSTeamDataTable);
        serverInteractor.saveTeam(SATeamDataTable);

        List<TeamDataTable> allTeams = serverInteractor.findAllTeams();
        int count = 0;
        for (TeamDataTable teamDataTable : allTeams) {
            if (teamDataTable.getTeamName().equals(GSString) || (teamDataTable.getTeamName().equals(SAString))) {
                count++;
            }
        }

        assertEquals(2, count);
    }

    @Test
    public void flushDB() throws IOException {
        serverInteractor.saveTeam(GSTeamDataTable);
        serverInteractor.saveTeam(SATeamDataTable);

        serverInteractor.flushDB();

        assertEquals(serverInteractor.findAllTeams().isEmpty(), true);
    }
}
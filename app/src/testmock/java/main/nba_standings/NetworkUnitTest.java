package main.nba_standings;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;

import main.nba_standings.interactor.dal.server.ServerInteractor;
import main.nba_standings.model.TeamDataTable;
import main.nba_standings.network.MockInterceptor;
import main.nba_standings.network.NetworkConfig;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static junit.framework.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 19, packageName = "main.nbastandings")
public class NetworkUnitTest {

    private MockInterceptor mockInterceptor;
    private ServerInteractor serverInteractor;

    private String mock;
    private TeamDataTable GSTeamDataTable;
    private TeamDataTable SATeamDataTable;

    private String url;
    private String GSString;

    private String GSJson;
    private String GSJsonArray;
    private String GSJsonArrayWithConference;
    private String GSAndSAJson;

    private MediaType JSON;

    @Before
    public void setup() throws Exception {
        mockInterceptor = new MockInterceptor();
        serverInteractor = new ServerInteractor();

        mock = "mock";
        GSTeamDataTable = new TeamDataTable(1, "Golden State", 73, 9, "A", "A", "A", "A", "A", false);
        SATeamDataTable = new TeamDataTable(2, "San Antonio", 69, 13, "B", "B", "B", "B", "B", false);

        url = NetworkConfig.SERVICE_ENDPOINT + "teams";
        GSString = "/Golden State";

        GSJson = "{\"rank\":1,\"teamName\":\"Golden State\",\"wins\":73,\"" +
                "losses\":9,\"conference\":\"A\",\"division\":\"A\",\"arenaName\":\"A\",\"city\":\"A\",\"state\":\"A\"" +
                ",\"isFavouriteTeam\":false}";
        GSJsonArray = "[" + GSJson + "]";
        GSJsonArrayWithConference = "{\"rank\":1,\"teamName\":\"Golden State\",\"wins\":73,\"losses\":9," +
                "\"conference\":\"Western\",\"division\":\"A\",\"arenaName\":\"A\",\"city\":\"A\",\"state\":\"A\",\"" +
                "isFavouriteTeam\":false}";
        GSAndSAJson = "[{\"rank\":1,\"teamName\":\"Golden State\",\"wins\":73,\"" +
                "losses\":9,\"conference\":\"A\",\"division\":\"A\",\"arenaName\":\"A\",\"city\":\"A\",\"state\":\"A\"" +
                ",\"isFavouriteTeam\":false},{\"rank\":2,\"teamName\":\"San Antonio\",\"wins\":69,\"losses\":13,\"conference\"" +
                ":\"B\",\"division\":\"B\",\"arenaName\":\"B\",\"city\":\"B\",\"state\":\"B\",\"isFavouriteTeam\":false}]";

        JSON = MediaType.parse("application/json; charset=utf-8");
    }

    @Test
    public void teamsGet() throws IOException {
        if (BuildConfig.FLAVOR == mock) {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            serverInteractor.saveTeam(GSTeamDataTable);

            Response response = mockInterceptor.process(request);
            assertEquals(response.body().string(), GSJsonArray);
        }
    }

    @Test
    public void teamsPut() throws IOException {
        if (BuildConfig.FLAVOR == mock) {
            serverInteractor.saveTeam(GSTeamDataTable);

            RequestBody body = RequestBody.create(JSON, GSJsonArrayWithConference);
            Request request = new Request.Builder()
                    .url(url).put(body)
                    .build();

            Response response = mockInterceptor.process(request);
            assertEquals(GSJsonArrayWithConference, response.body().string());
        }
    }

    @Test
    public void teamsPost() throws IOException {
        if (BuildConfig.FLAVOR == mock) {
            RequestBody body = RequestBody.create(JSON, GSJsonArrayWithConference);
            Request request = new Request.Builder()
                    .url(url).post(body)
                    .build();

            Response response = mockInterceptor.process(request);
            assertEquals(GSJsonArrayWithConference, response.body().string());
        }
    }

    @Test
    public void teamsTeamNameGet() throws IOException {
        if (BuildConfig.FLAVOR == mock) {
            serverInteractor.saveTeam(GSTeamDataTable);

            Request request = new Request.Builder()
                    .url(url + GSString)
                    .build();

            Response response = mockInterceptor.process(request);
            assertEquals(GSJson, response.body().string());
        }
    }

    @Test
    public void teamsTeamNameDelete() throws IOException {
        if (BuildConfig.FLAVOR == mock) {
            serverInteractor.saveTeam(GSTeamDataTable);

            Request request = new Request.Builder()
                    .url(url + GSString).delete()
                    .build();

            Response response = mockInterceptor.process(request);
            assertEquals("", response.body().string());
        }
    }
}
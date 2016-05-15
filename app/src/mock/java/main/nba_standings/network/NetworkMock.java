package main.nba_standings.network;

import android.net.Uri;

import javax.inject.Inject;

import main.nba_standings.interactor.dal.server.ServerInteractor;
import main.nba_standings.model.TeamDataTable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkMock {

    @Inject
    ServerInteractor serverInteractor;

    public Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "teams") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(serverInteractor.findAllTeams());
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams") && request.method().equals("PUT")) {
            responseString = GsonHelper.getGson().toJson(request.body());
            serverInteractor.updateTeam(TeamDataTable.createTeamDataTableFromJsonString(responseString));
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams") && request.method().equals("POST")) {
            responseString = GsonHelper.getGson().toJson(request.body());
            serverInteractor.saveTeam(TeamDataTable.createTeamDataTableFromJsonString(responseString));
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams/") && request.method().equals("GET")) {
            int startOfData = uri.getPath().lastIndexOf('/');
            String teamName = uri.getPath().substring(startOfData + 1);
            responseString = GsonHelper.getGson().toJson(serverInteractor.findTeam(teamName));
            responseCode = 200;
        }  else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams/") && request.method().equals("DELETE")) {
            int startOfData = uri.getPath().lastIndexOf('/');
            String teamName = uri.getPath().substring(startOfData + 1);
            serverInteractor.deleteTeam(teamName);

            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }
}
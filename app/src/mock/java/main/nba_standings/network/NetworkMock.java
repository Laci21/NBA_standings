package main.nba_standings.network;

import android.net.Uri;

import javax.inject.Inject;

import main.nba_standings.interactor.dal.server.ServerInteractor;
import main.nba_standings.model.TeamDataTable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Máté on 01/05/2016.
 */
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
            serverInteractor.updateTeam(new TeamDataTable());

            responseString = "";
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams") && request.method().equals("POST")) {
            serverInteractor.saveTeam(new TeamDataTable());

            responseString = "";
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams/") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(serverInteractor.findTeam(""));
            responseCode = 200;
        }  else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams/") && request.method().equals("DELETE")) {
            serverInteractor.deleteTeam("");

            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }
}
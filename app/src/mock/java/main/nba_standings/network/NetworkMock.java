package main.nba_standings.network;

import android.net.Uri;

import java.io.IOException;

import main.nba_standings.interactor.dal.server.ServerInteractor;
import main.nba_standings.model.TeamDataTable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

public class NetworkMock {

    private ServerInteractor serverInteractor;

    public NetworkMock(){
        serverInteractor = new ServerInteractor();
    }

    public Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "teams") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(serverInteractor.findAllTeams());
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams") && request.method().equals("PUT")) {
            final Buffer buffer = new Buffer();
            try {
                request.body().writeTo(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            responseString = GsonHelper.getGson().toJson(buffer.readUtf8());
            responseString = responseString.substring(1, responseString.length() - 1).replace("\\", "");
            serverInteractor.updateTeam(TeamDataTable.createTeamDataTableFromJsonString(responseString));
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "teams") && request.method().equals("POST")) {
            final Buffer buffer = new Buffer();
            try {
                request.body().writeTo(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            responseString = GsonHelper.getGson().toJson(buffer.readUtf8());
            responseString = responseString.substring(1, responseString.length() - 1).replace("\\", "");
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
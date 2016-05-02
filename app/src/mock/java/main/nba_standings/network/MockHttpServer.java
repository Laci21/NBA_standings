package main.nba_standings.network;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Máté on 01/05/2016.
 */
public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
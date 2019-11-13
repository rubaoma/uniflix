package br.unifor.uniflix.controller;

import br.unifor.uniflix.model.Filme;
import br.unifor.uniflix.model.Tvshow;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/tvshows")
public class TvShowsController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response airingToday() throws IOException {
        RequestFactory tvShows = new RequestFactory();
        Call call = tvShows.factoringCreate("/tv/airing_today");
        okhttp3.Response response = call.execute();


        if (response.isSuccessful()) {
            JSONObject jsonResponse = new  JSONObject(response.body().string());
            JSONArray result = jsonResponse.getJSONArray("results");
            List<Tvshow> tvshows = new ArrayList<>();
            for (int i = 0; i < result.length(); ++i) {
                JSONObject tvshowJson = result.getJSONObject(i);
                TvShowAdapter adp = new TvShowAdapter();
                Tvshow tvshow = adp.Adapter(tvshowJson);
                tvshows.add(tvshow);
            }
            return Response.ok(tvshows).build();
        }
        return Response.serverError().build();
    }
}
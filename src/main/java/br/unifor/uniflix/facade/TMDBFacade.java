package br.unifor.uniflix.facade;

import br.unifor.uniflix.controller.RequestFactory;
import br.unifor.uniflix.controller.TvShowAdapter;
import br.unifor.uniflix.model.Tvshow;
import okhttp3.Call;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TMDBFacade {
    public static Response ListaTvshows() throws IOException {
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

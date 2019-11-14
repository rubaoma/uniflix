package br.unifor.uniflix.facade;

import br.unifor.uniflix.controller.FilmeAdapter;
import br.unifor.uniflix.controller.RequestFactory;
import br.unifor.uniflix.controller.TvShowAdapter;
import br.unifor.uniflix.model.Filme;
import br.unifor.uniflix.model.Tvshow;
import okhttp3.Call;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TMDBFacade {

    public List<Tvshow> ListaTvshows() throws IOException {
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
            return tvshows;
        }
        return null;
    }


    public List<Filme> ListaFilmes() throws IOException {
        RequestFactory movies = new RequestFactory();
        Call call = movies.factoringCreate("/movie/popular");
        okhttp3.Response response = call.execute();

        if (response.isSuccessful()) {
            JSONObject jsonResponse = new  JSONObject(response.body().string());
            JSONArray result = jsonResponse.getJSONArray("results");
            List<Filme> filmes = new ArrayList<>();
            for (int i = 0; i < result.length(); ++i) {
                JSONObject movieJson = result.getJSONObject(i);
                FilmeAdapter adp = new FilmeAdapter();
                Filme filme = adp.Adapter(movieJson);
                filmes.add(filme);
            }
            return filmes;
        }
        return null;
    }
}

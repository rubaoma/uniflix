package br.unifor.uniflix.controller;

import br.unifor.uniflix.model.Tvshow;
import org.json.JSONObject;

public class TvShowAdapter implements JsonAdapter<Tvshow>{
    @Override
    public Tvshow Adapter(JSONObject tvshowJson){
        Tvshow tvshow = new Tvshow();
        tvshow.setNome(tvshowJson.getString("name"));
        tvshow.setDescricao(tvshowJson.getString("overview"));
        tvshow.setPopularidade(tvshowJson.getDouble("popularity"));
        return tvshow;
    }
}

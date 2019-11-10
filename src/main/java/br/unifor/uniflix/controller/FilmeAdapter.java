package br.unifor.uniflix.controller;

import br.unifor.uniflix.model.Filme;
import org.json.JSONObject;

public class FilmeAdapter implements JsonAdapter<Filme> {

    @Override
    public Filme Adapter(JSONObject movieJson) {
        Filme filme = new Filme();
        filme.setTitulo(movieJson.getString("title"));
        filme.setSinopse(movieJson.getString("overview"));
        filme.setAdulto(movieJson.getBoolean("adult"));
        filme.setNota(movieJson.getDouble("vote_average"));
        return filme;
    }
}

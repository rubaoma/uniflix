package br.unifor.uniflix.controller;

import br.unifor.uniflix.model.Tvshow;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public abstract interface JsonAdapter <T> {
    abstract T Adapter(JSONObject value);

    public List <T> adapterJsonArray(JSONArray result) {
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < result.length(); ++i) {
            JSONObject tvshowJson = result.getJSONObject(i);
            T obj = this.Adapter(tvshowJson);
            list.add(obj);
        }
    return list;
}


}

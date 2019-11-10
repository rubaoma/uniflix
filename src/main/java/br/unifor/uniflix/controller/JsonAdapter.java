package br.unifor.uniflix.controller;

import org.json.JSONObject;


public interface JsonAdapter <T> {
    T Adapter (JSONObject value);

}

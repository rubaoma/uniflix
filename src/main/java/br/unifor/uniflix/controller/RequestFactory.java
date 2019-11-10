package br.unifor.uniflix.controller;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class RequestFactory {

    public RequestFactory(String path) {
    }

    public Call request (String path){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3" + path +"?api_key=08c2e5168cee4e22b7ee7211c13214a0")
                .build();
        return client.newCall(request);
    }

}

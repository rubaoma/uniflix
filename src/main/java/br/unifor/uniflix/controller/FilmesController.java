package br.unifor.uniflix.controller;

import br.unifor.uniflix.facade.TMDBFacade;
import br.unifor.uniflix.model.Filme;
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

@Path("/filmes")
public class FilmesController {
    TMDBFacade facade = new TMDBFacade();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response airingToday() throws IOException {

        List<Filme> filmes = facade.ListaFilmes();
        if( filmes == null ){
            return Response.serverError().build();
        }
        return Response.ok(filmes).build();

    }

}

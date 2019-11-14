package br.unifor.uniflix.controller;

import br.unifor.uniflix.facade.TMDBFacade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/tvshows")
public class TvShowsController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response airingToday() throws IOException {
        return TMDBFacade.ListaTvshows();
    }
}
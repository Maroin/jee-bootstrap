package org.isen.draughts.jaxrs;

import java.awt.*;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.isen.draughts.jpa.adapter.DraughtsAdapter;

public class DraughtsGameResource {


    @Context
    UriInfo info;



    private DraughtsAdapter game;

    public DraughtsGameResource(DraughtsAdapter game) {
        this.game = game;
    }


    @GET
    public DraughtsAdapter  doGet() throws IOException {
        return game;
    }


    @POST
    @Path("{colNumber}")
    public Response play(@PathParam("colNumber") int col) throws IOException {
        game.play( new Point(3,3),new Point(4,4),game.getCurrentTurn());
        return Response
                .status(Response.Status.SEE_OTHER)
                .header(HttpHeaders.LOCATION,
                        info.getBaseUri() + game.getToken())
                .build();

    }





}

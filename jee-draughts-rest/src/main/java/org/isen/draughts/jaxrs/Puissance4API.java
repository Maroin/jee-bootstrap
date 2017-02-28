package org.isen.draughts.jaxrs;

import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/")
@Produces({ "application/json", "*/*" })
@RequestScoped
public class Puissance4API {

    @Inject
    DraughtsDAO dao;

    @Context
    HttpServletRequest request;

    @Context
    ResourceContext rc;

    @GET
    public Response doGet() {
        DraughtsAdapter game = dao.createNewGame();
        return Response
                .status(Response.Status.SEE_OTHER)
                .header(HttpHeaders.LOCATION,
                        request.getContextPath() + "/api/" + game.getToken())
                .build();
    }

    @Path("{gameToken}")
    public Object getGame(@PathParam("gameToken") String token) {
        DraughtsAdapter game = dao.loadFromToken(token);
        return rc.initResource(new Puissance4GameResource(game));
    }
}

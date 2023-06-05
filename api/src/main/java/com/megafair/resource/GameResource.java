package com.megafair.resource;

import com.megafair.model.PlatformRequest;
import com.megafair.service.GameService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/game")
@RequestScoped
public class GameResource {

    @Inject
    GameService gameService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("platform")
    public Response redirectToGame(PlatformRequest request) {
        String resourceUrl = gameService.getResourceUrl(request.getPlatformName(), request.getRequestedResource());
        if (resourceUrl != null) {
            // redirect to resource if the platform has access to the game
            URI uri = URI.create(resourceUrl);
            return Response.seeOther(uri).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    // Mock game resource
    @Path("/get")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response play() {
        return Response.ok("Play").build();
    }
}

package com.megafair.resource;

import com.megafair.service.AuthService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/jwt")
@RequestScoped
public class AuthResource {

    @Inject
    AuthService authService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJwt(){
        //todo Should receive auth info and compare it with db
        return Response.ok(authService.generateJwt()).build();
    }
}

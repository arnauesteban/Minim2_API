package edu.upc.dsa.services;


import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.models.Badge;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/Badges", description = "Endpoint to Badge Service")
@Path("/Badges")
public class Service {

    private Manager m;

    public Service() {
        this.m = ManagerImpl.getInstance();
        if (m.size()==0) {
            this.m.addBadge("El mas jugon", "http://localhost:8080/img/badge/jugon.png");
            this.m.addBadge("El mas epico", "http://localhost:8080/img/badge/epico.png");
            this.m.addBadge("El mas lento", "http://localhost:8080/img/badge/lento.png");

            List<String> badges = new LinkedList<>();
            badges.add("jugon");
            badges.add("lento");

            this.m.addUser("arnauem", "http://10.0.2.2:8080/img/avatar.png",
                    "Arnau", "Esteban", badges);
        }

    }

    @GET
    @ApiOperation(value = "get all badges", notes = "get all badges")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Badge.class, responseContainer="List"),
    })
    @Path("/badges")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBadges() {

        List<Badge> badges = this.m.findAllBadges();

        GenericEntity<List<Badge>> entity = new GenericEntity<List<Badge>>(badges) {};
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "get a User", notes = "get a user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class)
    })
    @Path("/user/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("username") String username) {
        User u = this.m.getUser(username);

        return Response.status(201).entity(u).build();
    }

}
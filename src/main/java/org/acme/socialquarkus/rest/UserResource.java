package org.acme.socialquarkus.rest;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.socialquarkus.dto.UserRequest;

@Path("/users")
public class UserResource {


    @POST
    public Response createUser(UserRequest request){

        return Response.ok().build();
    }

    @PUT
    public Response updateUser(UserRequest request){

        return Response.ok().build();
    }

    @GET
    public Response getUser(){

        return Response.ok().build();
    }

    @GET
    public Response getUsers(){

        return Response.ok().build();
    }

    @DELETE
    public Response deleteUser(@PathParam("id") String id){

        return Response.ok().build();
    }



}

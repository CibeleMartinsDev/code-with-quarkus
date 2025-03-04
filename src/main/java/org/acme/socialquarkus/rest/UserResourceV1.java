package org.acme.socialquarkus.rest;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.socialquarkus.dto.UserRequest;
import org.acme.socialquarkus.service.UserService;

@Path("/api/v1/users") // caminho para chamada dos endpoint do Resource
@Produces(MediaType.APPLICATION_JSON) // o que o resource/api produz/pode retornar
@Consumes(MediaType.APPLICATION_JSON) // o que o resource/api pode consumir/receber
public class UserResourceV1 {

    //Inject/definicao de servicos e utilitários
    @Inject
    UserService userService;
    /**
     * Endpoint utilizado para criar/cadastrar um usuário.
     * A anotacão @POST define esse método como um endpoint rest POST,
     * permitindo requisicoes desse tipo p/ ele.
     * @param request
     * @return Response --> UserRequest
     */
    @POST
    public Response createUser(UserRequest request){
        userService.createUser(request);
        return Response.ok("Operacao realizada com sucesso!").build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Integer id, UserRequest request){
        return Response.ok(userService.putUserById(id, request)).build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Integer id) {
        return Response.ok(userService.getUserById(id)).build();
    }

    @GET
    public Response getUsers(){
        return Response.ok(userService.getUsers()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id){
        return userService.deleteUserById(id);
    }



}

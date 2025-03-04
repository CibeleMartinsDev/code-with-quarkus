package org.acme.socialquarkus.service;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.socialquarkus.domain.model.SocialUser;
import org.acme.socialquarkus.dto.UserRequest;

import java.util.List;

@ApplicationScoped // define a classe como um bean injetável
public class UserService {

    @Transactional // todo método que interage com o BD precisa ser anotado com transacional
    public void createUser(UserRequest userRequest){
            SocialUser socialUser = new SocialUser();
            socialUser.setAge(userRequest.getAge());
            socialUser.setEmail(userRequest.getEmail());
            socialUser.setName(userRequest.getName());
            SocialUser.persist(socialUser);
    }
    @Transactional
    public List<PanacheEntityBase> getUsers(){
       PanacheQuery<PanacheEntityBase> query = SocialUser.findAll();
       return query.list();
    }
    @Transactional
    public Object getUserById(Integer id) {
        SocialUser user = SocialUser.findById(id);
        return user != null ? user : Response.status(Response.Status.NOT_FOUND).build();
    }
    @Transactional
    public Response deleteUserById(String id) {
        SocialUser user = SocialUser.findById(id);
        if(user != null ){
            SocialUser.deleteById(user.getId());
            return Response.status(Response.Status.OK.getStatusCode()).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND.getStatusCode()).build();
        }
    }
    @Transactional
    public Response putUserById(Integer id, UserRequest userRequest) {

        SocialUser user = SocialUser.findById(id);
        if(user != null){
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setAge(userRequest.getAge());
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

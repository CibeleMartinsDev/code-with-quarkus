package org.acme.socialquarkus.service;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.vertx.mutiny.ext.auth.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
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
}

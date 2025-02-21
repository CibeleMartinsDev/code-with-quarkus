package org.acme.socialquarkus.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SocialUser extends PanacheEntityBase {

    /**
     * quando vc utiliza, extends o PanacheEntity
     * ele ja tem o id, n precisa definir na entidade
     * a prórpria entidade terá os métodos persistencia/para realizar
     * operacoes no banco de dados. No entanto, PanacheEntity nao define
     * a strategy de geracao de id, o que pode resultar em erros
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    /**
     * Então basta utilizar o PanacheEntityBase e add o id novamente
     */
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "idade")
    private String age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialUser user = (SocialUser) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

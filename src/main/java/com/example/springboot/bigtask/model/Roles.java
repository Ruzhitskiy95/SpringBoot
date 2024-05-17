package com.example.springboot.bigtask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "rolesss")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer rolesId;

    @Column(name = "role")
    private String role;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles",cascade = CascadeType.ALL)
    private List<Users> users;


    public Roles() {
    }

    public Roles(Integer rolesId, String role, List<Users> usersSpringSecurities) {
        this.rolesId = rolesId;
        this.role = role;
        this.users = usersSpringSecurities;
    }

    public Roles(Integer rolesId, String role) {
        this.rolesId = rolesId;
        this.role = role;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Users> getUsersSSES() {
        return users;
    }

    public void setUsersSSES(List<Users> usersSpringSecurities) {
        this.users = usersSpringSecurities;
    }

    @Override
    public String toString() {
        return "RolesSS{" +
                "rolesId=" + rolesId +
                ", role='" + role + '\'' +
                ", usersSSES=" + users +
                '}';
    }
}

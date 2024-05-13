package com.example.springboot.bigtask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "rolesss")
public class RolesSS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer rolesId;

    @Column(name = "role")
    private String role;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "rolesSSES")
    private List<UsersSS> usersSSES;


    public RolesSS() {
    }

    public RolesSS(Integer rolesId, String role, List<UsersSS> usersSSES) {
        this.rolesId = rolesId;
        this.role = role;
        this.usersSSES = usersSSES;
    }

    public RolesSS(Integer rolesId, String role) {
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

    public List<UsersSS> getUsersSSES() {
        return usersSSES;
    }

    public void setUsersSSES(List<UsersSS> usersSSES) {
        this.usersSSES = usersSSES;
    }

    @Override
    public String toString() {
        return "RolesSS{" +
                "rolesId=" + rolesId +
                ", role='" + role + '\'' +
                ", usersSSES=" + usersSSES +
                '}';
    }
}

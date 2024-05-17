package com.example.springboot.bigtask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usersss")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    private Integer kol;

    @JsonIgnore
    @OneToMany(mappedBy = "users", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Task> tasks;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @CollectionTable(name = "usersss_rolesss")
    private List<Roles> roles;



    public Users() {
    }

    public Users(Integer id, String username, String password, String name, String department, Integer kol, List<Task> tasks, List<Roles> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
        this.kol = kol;
        this.tasks = tasks;
        this.roles = roles;
    }

    public Users(Integer id, String username, String password, String name, String department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
    }

    public Users(Integer id, String username, String password, String name, String department, Integer kol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
        this.kol = kol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getKol() {
        return kol;
    }

    public void setKol(Integer kol) {
        this.kol = kol;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", kol=" + kol +
//                ", tasks=" + tasks +
//                ", roles=" + roles +
                '}';
    }
}

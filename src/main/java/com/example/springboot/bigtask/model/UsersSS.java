package com.example.springboot.bigtask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usersss")
public class UsersSS {

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


    @OneToMany(mappedBy = "usersSS")
    private List<TaskSS> taskSSES;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @CollectionTable(name = "usersss_rolesss")
    private List<RolesSS> rolesSSES;



    public UsersSS() {
    }

    public UsersSS(Integer id, String username, String password, String name, String department, List<TaskSS> taskSSES, List<RolesSS> rolesSSES) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
        this.taskSSES = taskSSES;
        this.rolesSSES = rolesSSES;
    }

    public UsersSS(Integer id, String username, String password, String name, String department, List<TaskSS> taskSSES) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
        this.taskSSES = taskSSES;
    }

    public UsersSS(Integer id, String username, String password, String name, String department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
    }

    public UsersSS(Integer id, String username, String password, String name, String department, Integer kol, List<TaskSS> taskSSES, List<RolesSS> rolesSSES) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
        this.kol = kol;
        this.taskSSES = taskSSES;
        this.rolesSSES = rolesSSES;
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

    public List<TaskSS> getTaskSSES() {
        return taskSSES;
    }

    public void setTaskSSES(List<TaskSS> taskSSES) {
        this.taskSSES = taskSSES;
    }

    public List<RolesSS> getRolesSSES() {
        return rolesSSES;
    }

    public void setRolesSSES(List<RolesSS> rolesSSES) {
        this.rolesSSES = rolesSSES;
    }

    public Integer getKol() {
        return kol;
    }

    public void setKol(Integer kol) {
        this.kol = kol;
    }

    @Override
    public String toString() {
        return "UsersSS{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", taskSSES=" + taskSSES +
//                ", rolesSSES=" + rolesSSES +
                '}';
    }
}

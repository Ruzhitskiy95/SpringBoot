package com.example.springboot.bigtask.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "taskss")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descriptions")
    private  String descriptions;

    @Column(name = "createdData")
    private Date createdData;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Users users;

    public Task() {
    }

    public Task(Integer id, String descriptions, Date createdData) {
        this.id = id;
        this.descriptions = descriptions;
        this.createdData = createdData;
    }

    public Task(Integer id, String descriptions, Date createdData, Users users) {
        this.id = id;
        this.descriptions = descriptions;
        this.createdData = createdData;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Date getCreatedData() {
        return createdData;
    }

    public void setCreatedData(Date createdData) {
        this.createdData = createdData;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", descriptions='" + descriptions + '\'' +
                ", createdData=" + createdData +
//                ", users=" + users +
                '}';
    }
}

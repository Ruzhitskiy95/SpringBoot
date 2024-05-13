package com.example.springboot.bigtask.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "taskss")
public class TaskSS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descriptions")
    private  String descriptions;

    @Column(name = "createdData")
    private Date createdData;


    @JsonIgnore
    @ManyToOne
    private UsersSS usersSS;

    public TaskSS() {
    }

    public TaskSS(Integer id, String descriptions, Date createdData, UsersSS usersSS) {
        this.id = id;
        this.descriptions = descriptions;
        this.createdData = createdData;
        this.usersSS = usersSS;
    }

    public TaskSS(Integer id, String descriptions, Date createdData) {
        this.id = id;
        this.descriptions = descriptions;
        this.createdData = createdData;
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

    public UsersSS getUsersSS() {
        return usersSS;
    }

    public void setUsersSS(UsersSS usersSS) {
        this.usersSS = usersSS;
    }

    @Override
    public String toString() {
        return "TaskSS{" +
                "id=" + id +
                ", descriptions='" + descriptions + '\'' +
                ", createdData=" + createdData +
//                ", usersSS=" + usersSS +
                '}';
    }
}

package com.example.springboot.task47_49.model;


import jakarta.persistence.*;

@Entity
@Table(name = "user_subscriptions")
public class UserSubscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", insertable=false, updatable=false)
    private Integer userId;

    @Column(name = "subscriptions")
    private Integer subscriptions;

    @ManyToOne
    private UsersTask47 usersTask47;

    public UserSubscriptions() {
    }

    public UserSubscriptions(Integer id, Integer userId, Integer subscriptions, UsersTask47 usersTask47) {
        this.id = id;
        this.userId = userId;
        this.subscriptions = subscriptions;
        this.usersTask47 = usersTask47;
    }

    public UserSubscriptions(Integer id, Integer userId, Integer subscriptions) {
        this.id = id;
        this.userId = userId;
        this.subscriptions = subscriptions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Integer subscriptions) {
        this.subscriptions = subscriptions;
    }

    public UsersTask47 getUsers() {
        return usersTask47;
    }

    public void setUser(UsersTask47 usersTask47) {
        this.usersTask47 = usersTask47;
    }

    @Override
    public String toString() {
        return "UserSubscriptions{" +
                "id=" + id +
                ", userId=" + userId +
                ", subscriptions=" + subscriptions +
                '}';
    }
}

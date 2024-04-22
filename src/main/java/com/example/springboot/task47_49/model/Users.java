package com.example.springboot.task47_49.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usersrest")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Posts> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<UserSubscriptions> userSubscriptions;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<PostView> postViews;

    public Users() {
    }

    public Users(Integer id, String name, List<Posts> posts, List<UserSubscriptions> userSubscriptions, List<PostView> postViews) {
        this.id = id;
        this.name = name;
        this.posts = posts;
        this.userSubscriptions = userSubscriptions;
        this.postViews = postViews;
    }

    public Users(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public List<UserSubscriptions> getUserSubscriptions() {
        return userSubscriptions;
    }

    public void setUserSubscriptions(List<UserSubscriptions> userSubscriptions) {
        this.userSubscriptions = userSubscriptions;
    }

    public List<PostView> getPostViews() {
        return postViews;
    }

    public void setPostViews(List<PostView> postViews) {
        this.postViews = postViews;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

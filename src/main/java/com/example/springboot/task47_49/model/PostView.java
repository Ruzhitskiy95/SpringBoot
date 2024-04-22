package com.example.springboot.task47_49.model;


import jakarta.persistence.*;

@Entity
@Table(name = "post_view")
public class PostView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_id", insertable=false, updatable=false)
    private Integer postId;

    @Column(name = "views")
    private Integer views;

    @ManyToOne
    private Users users;

    public PostView() {
    }

    public PostView(Integer id, Integer postId, Integer views) {
        this.id = id;
        this.postId = postId;
        this.views = views;
    }

    public PostView(Integer id, Integer postId, Integer views, Users users) {
        this.id = id;
        this.postId = postId;
        this.views = views;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "PostView{" +
                "id=" + id +
                ", postId=" + postId +
                ", views=" + views +
                '}';
    }
}

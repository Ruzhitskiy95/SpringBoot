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
    private UsersTask47 usersTask47;

    public PostView() {
    }

    public PostView(Integer id, Integer postId, Integer views) {
        this.id = id;
        this.postId = postId;
        this.views = views;
    }

    public PostView(Integer id, Integer postId, Integer views, UsersTask47 usersTask47) {
        this.id = id;
        this.postId = postId;
        this.views = views;
        this.usersTask47 = usersTask47;
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

    public UsersTask47 getUsers() {
        return usersTask47;
    }

    public void setUsers(UsersTask47 usersTask47) {
        this.usersTask47 = usersTask47;
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

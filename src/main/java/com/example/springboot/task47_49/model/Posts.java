package com.example.springboot.task47_49.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "postsrest")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "users_id", insertable=false, updatable=false)
    private Integer usersId;

    @Column(name = "price")
    private Integer price;


    @ManyToOne
    private Users users;

    public Posts() {
    }

    public Posts(Integer id, Integer usersId, Integer price, Users user) {
        this.id = id;
        this.usersId = usersId;
        this.price = price;
        this.users = user;
    }

    public Posts(Integer id, Integer usersId, Integer price) {
        this.id = id;
        this.usersId = usersId;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", usersId=" + usersId +
                ", price=" + price +
                '}';
    }
}

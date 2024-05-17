package com.example.springboot.task47_49.model;


import jakarta.persistence.*;

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
    private UsersTask47 usersTask47;

    public Posts() {
    }

    public Posts(Integer id, Integer usersId, Integer price, UsersTask47 user) {
        this.id = id;
        this.usersId = usersId;
        this.price = price;
        this.usersTask47 = user;
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

    public UsersTask47 getUser() {
        return usersTask47;
    }

    public void setUser(UsersTask47 usersTask47) {
        this.usersTask47 = usersTask47;
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

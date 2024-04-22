package com.example.springboot.task47_49.dao;

import com.example.springboot.task47_49.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsDao extends JpaRepository<Posts, Long> {
    List<Posts> findAllById(Integer id);

    @Query(value = "SELECT * from postsrest pr where pr.users_id in (select us.user_id from user_subscriptions us where us.subscriptions > 500)", nativeQuery = true)
        List<Posts> getPosts();

}

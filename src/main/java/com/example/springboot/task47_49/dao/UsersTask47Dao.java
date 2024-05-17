package com.example.springboot.task47_49.dao;


import com.example.springboot.task47_49.model.UsersTask47;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersTask47Dao extends JpaRepository<UsersTask47, Long> {


    @Query(value = "SELECT * from usersrest ur where ur.id in (select pr.users_id from postsrest pr where pr.id in (select pw.id from  post_view pw where views > 500))", nativeQuery = true)
    List<UsersTask47> getUsers();

}

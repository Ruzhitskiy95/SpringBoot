package com.example.springboot.bigtask.dao;

import com.example.springboot.bigtask.model.TaskSS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskSSDao extends JpaRepository<TaskSS, Long>, JpaSpecificationExecutor<TaskSS> {

    @Query(value = "select  ts.id, ts.created_data, ts.descriptions, ts.usersss_id from taskss ts where usersss_id in\n" +
            "(select us.id from usersss us where username = :name) and date_part('month', created_data) = :chousemounth", nativeQuery = true)


    List<TaskSS> getTasks(@Param("name") final String name,
                                    @Param("chousemounth") final Integer chousemounth);

}

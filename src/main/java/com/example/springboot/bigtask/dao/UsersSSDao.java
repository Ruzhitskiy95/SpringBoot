package com.example.springboot.bigtask.dao;

import com.example.springboot.bigtask.model.UsersSS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersSSDao extends JpaRepository<UsersSS, Long>, JpaSpecificationExecutor<UsersSS> {


    UsersSS findUsersSSByUsername(final String username);


    @Query(value = "select us.id, us.department, us.name, us.password, us.username, count(ts.usersss_id) as kol from usersss us\n" +
            "    inner join public.taskss ts on us.id = ts.usersss_id where us.department =\n" +
            "            (select us.department from usersss us where username = :name) and date_part('month', created_data) = :chousemounth\n" +
            "    group by us.id", nativeQuery = true)

    List<UsersSS> getUsersManagerDepartment(@Param("name") final String name,
                                            @Param("chousemounth") final Integer chousemounth);


    @Query(value = "select us.id, us.department, us.name, us.password, us.username, us.kol, ts.descriptions, ts.created_data from usersss us\n" +
            " inner join public.taskss ts on us.id = ts.usersss_id where us.department =\n" +
           " (select us.department from usersss us where username = :name) and date_part('month', created_data) = :chousemounth", nativeQuery = true)

    List<UsersSS> getUserManagerInfo(@Param("name") final String name,
                                            @Param("chousemounth") final Integer chousemounth);

    @Query(value = "select count(distinct us.id) as kol from usersss us\n" +
            " inner join public.usersss_rolesss ur on us.id = ur.userssses_id\n" +
            " where ur.rolessses_id = (select r.id from rolesss r where r.role = 'Manager')", nativeQuery = true)

    Integer getManagerCount();

    @Query(value = "select  us.id, us.department, us.name, us.password, us.username, count(t.usersss_id) as kol from usersss us inner join public.taskss t on us.id = t.usersss_id\n" +
            "where date_part('month', created_data) = :chousemounth group by us.id", nativeQuery = true)

    List<UsersSS> getUsersDepartmentByMounth(@Param("chousemounth") final Integer chousemounth);

    @Query(value = "select us.id, us.department, us.name, us.password, us.username, us.kol from usersss us\n" +
            "    inner join public.taskss t on us.id = t.usersss_id\n" +
            "    where us.department = (select us.department from usersss us where  us.username = :name)", nativeQuery = true)

    List<UsersSS> getManagerInfoAndDepartment(@Param("name") final String name);

    @Query(value = "select us.id, us.department, us.name, us.password, us.username, us.kol from usersss us\n" +
            "inner join public.taskss t on us.id = t.usersss_id\n" +
            "where us.name = :name", nativeQuery = true)

    List<UsersSS> getUserInfoAndTasksByName(@Param("name") final String name);



}

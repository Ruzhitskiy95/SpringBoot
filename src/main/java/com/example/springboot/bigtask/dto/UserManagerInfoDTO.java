package com.example.springboot.bigtask.dto;

import com.example.springboot.bigtask.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManagerInfoDTO {


    private String username;

    private String department;

    private List<Task> taskSpringSecurities;


    public UserManagerInfoDTO() {
    }

    public UserManagerInfoDTO(String username, String department, List<Task> taskSpringSecurities) {
        this.username = username;
        this.department = department;
        this.taskSpringSecurities = taskSpringSecurities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Task> getTaskSSES() {
        return taskSpringSecurities;
    }

    public void setTaskSSES(List<Task> taskSpringSecurities) {
        this.taskSpringSecurities = taskSpringSecurities;
    }

    @Override
    public String toString() {
        return "UserManagerInfoDTO{" +
                "username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", taskSSES=" + taskSpringSecurities +
                '}';
    }
}

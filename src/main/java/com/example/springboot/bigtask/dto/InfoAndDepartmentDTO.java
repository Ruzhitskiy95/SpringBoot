package com.example.springboot.bigtask.dto;

import com.example.springboot.bigtask.model.TaskSS;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoAndDepartmentDTO {

    private String username;

    private String department;

    private List<TaskSS> taskSSES;

    public InfoAndDepartmentDTO(String username, String department, List<TaskSS> taskSSES) {
        this.username = username;
        this.department = department;
        this.taskSSES = taskSSES;
    }

    public InfoAndDepartmentDTO() {
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

    public List<TaskSS> getTaskSSES() {
        return taskSSES;
    }

    public void setTaskSSES(List<TaskSS> taskSSES) {
        this.taskSSES = taskSSES;
    }

    @Override
    public String toString() {
        return "ManagerInfoAndDepartmentDTO{" +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", taskSSES=" + taskSSES +
                '}';
    }
}

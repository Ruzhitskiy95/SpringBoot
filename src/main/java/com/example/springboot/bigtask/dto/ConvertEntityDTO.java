package com.example.springboot.bigtask.dto;

import com.example.springboot.bigtask.model.TaskSS;
import com.example.springboot.bigtask.model.UsersSS;
import org.springframework.stereotype.Component;

@Component
public class ConvertEntityDTO {

    public TasksEngineerDTO mapToTaskEngineerDTO (TaskSS taskSS){
        TasksEngineerDTO tasksEngineerDTO = new TasksEngineerDTO();
        tasksEngineerDTO.setCreatedData(taskSS.getCreatedData());
        tasksEngineerDTO.setDescriptions(taskSS.getDescriptions());
        return tasksEngineerDTO;
    }


    public UserManagerDepartmentDTO mapToUserManagerDepartmentDTO (UsersSS usersSS){
        UserManagerDepartmentDTO userManagerDepartmentDTO = new UserManagerDepartmentDTO();
        userManagerDepartmentDTO.setDepartment(usersSS.getDepartment());
        userManagerDepartmentDTO.setUsername(usersSS.getUsername());
        userManagerDepartmentDTO.setKol(usersSS.getKol());
        return userManagerDepartmentDTO;
    }

    public UserManagerInfoDTO mapToUserManagerInfoDTO (UsersSS usersSS){
        UserManagerInfoDTO userManagerInfoDTO = new UserManagerInfoDTO();
        userManagerInfoDTO.setUsername(usersSS.getUsername());
        userManagerInfoDTO.setDepartment(usersSS.getDepartment());
        userManagerInfoDTO.setTaskSSES(usersSS.getTaskSSES());
        return userManagerInfoDTO;
    }

    public UsersDepartmentByMounthDTO mapToTaskDepartmentByMounth  (UsersSS usersSS){
        UsersDepartmentByMounthDTO usersDepartmentByMounthDTO = new UsersDepartmentByMounthDTO();
        usersDepartmentByMounthDTO.setDepart(usersSS.getDepartment());
        usersDepartmentByMounthDTO.setKol(usersSS.getKol());
        return usersDepartmentByMounthDTO;
    }

    public InfoAndDepartmentDTO mapToManagerInfoAndDepartmentDTO (UsersSS usersSS){
        InfoAndDepartmentDTO infoAndDepartmentDTO = new InfoAndDepartmentDTO();
        infoAndDepartmentDTO.setDepartment(usersSS.getDepartment());
        infoAndDepartmentDTO.setTaskSSES(usersSS.getTaskSSES());
        infoAndDepartmentDTO.setUsername(usersSS.getUsername());
        return infoAndDepartmentDTO;
    }

}

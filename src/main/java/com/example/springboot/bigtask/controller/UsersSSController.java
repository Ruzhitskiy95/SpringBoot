package com.example.springboot.bigtask.controller;

import com.example.springboot.bigtask.dao.TaskSSDao;
import com.example.springboot.bigtask.dao.UsersSSDao;
import com.example.springboot.bigtask.dto.*;
import com.example.springboot.bigtask.model.TaskSS;
import com.example.springboot.bigtask.model.UsersSS;
import com.example.springboot.bigtask.config.JwtService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "APIControllers", description = "Controllers BIG Task")
public class UsersSSController {

    @Autowired
    UsersSSDao usersSSDao;

    @Autowired
    TaskSSDao taskSSDao;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/engineer")
    public ResponseEntity<List<TasksEngineerDTO>> getEngineer(){
        String nameuser = SecurityContextHolder.getContext().getAuthentication().getName();
        List<TaskSS>  taskSSES = taskSSDao.getTasks(nameuser, 5);
        List<TasksEngineerDTO> tasksEngineerDTOList = new ArrayList<>();

        ConvertEntityDTO convertEntityDTO = new ConvertEntityDTO();

        for (TaskSS taskSS: taskSSES) {
            tasksEngineerDTOList.add(convertEntityDTO.mapToTaskEngineerDTO(taskSS));
        }
        System.out.println(tasksEngineerDTOList.toString());
        return  ResponseEntity.ok(tasksEngineerDTOList);
    }

    @GetMapping("/admin/getManagersCount")
    public ResponseEntity<Integer> getManagersCount(){
        Integer kol = usersSSDao.getManagerCount();
        return  ResponseEntity.ok(kol);
    }

    @GetMapping("/admin/getUsersDepartmentByMounth")
    public ResponseEntity<List<UsersDepartmentByMounthDTO>> getUsersDepartmentByMounth(){
        List<UsersSS> usersSSES = usersSSDao.getUsersDepartmentByMounth(5);
        List<UsersDepartmentByMounthDTO> usersDepartmentByMounthDTOS = new ArrayList<>();
        ConvertEntityDTO convertEntityDTO = new ConvertEntityDTO();
        for (UsersSS usersSS: usersSSES) {
            usersDepartmentByMounthDTOS.add(convertEntityDTO.mapToTaskDepartmentByMounth(usersSS));
        }
        return  ResponseEntity.ok(usersDepartmentByMounthDTOS);
    }

    @GetMapping("/admin/getManagerInfoAndDepartment")
    public ResponseEntity<List<InfoAndDepartmentDTO>> getManagerInfoAndDepartment(){
        List<UsersSS> usersSSES = usersSSDao.getManagerInfoAndDepartment("Tom");
        List<InfoAndDepartmentDTO> infoAndDepartmentDTOS = new ArrayList<>();
        ConvertEntityDTO convertEntityDTO = new ConvertEntityDTO();
        for (UsersSS usersSS: usersSSES) {
            infoAndDepartmentDTOS.add(convertEntityDTO.mapToManagerInfoAndDepartmentDTO(usersSS));
        }
        return  ResponseEntity.ok(infoAndDepartmentDTOS);
    }

    @GetMapping("/admin/getUserInfoAndTasksByName")
    public ResponseEntity<List<InfoAndDepartmentDTO>> getUserInfoAndTasksByName(){
        List<UsersSS> usersSSES = usersSSDao.getUserInfoAndTasksByName("Rikki");
        List<InfoAndDepartmentDTO> infoAndDepartmentDTOS = new ArrayList<>();
        ConvertEntityDTO convertEntityDTO = new ConvertEntityDTO();
        for (UsersSS usersSS: usersSSES) {
            infoAndDepartmentDTOS.add(convertEntityDTO.mapToManagerInfoAndDepartmentDTO(usersSS));
        }
        return  ResponseEntity.ok(infoAndDepartmentDTOS);
    }

    @GetMapping("/manager/getUsersDepartment")
    public ResponseEntity<List<UserManagerDepartmentDTO>> getManager(){
        String nameuser = SecurityContextHolder.getContext().getAuthentication().getName();
        List<UsersSS>  usersSSES= usersSSDao.getUsersManagerDepartment(nameuser,5);

        List<UserManagerDepartmentDTO> userManagerDepartmentDTOS = new ArrayList<>();
        ConvertEntityDTO convertEntityDTO = new ConvertEntityDTO();
        for (UsersSS usersSS: usersSSES) {
            userManagerDepartmentDTOS.add(convertEntityDTO.mapToUserManagerDepartmentDTO(usersSS));
        }

        System.out.println(usersSSES.toString());
        return  ResponseEntity.ok(userManagerDepartmentDTOS);
    }

    @GetMapping("/manager/getUsersInfo")
    public ResponseEntity<List<UserManagerInfoDTO>> getManagerInfo(){
        String nameuser = SecurityContextHolder.getContext().getAuthentication().getName();
        List<UsersSS>  usersSSES= usersSSDao.getUserManagerInfo(nameuser,5);

        List<UserManagerInfoDTO> userManagerInfoDTOS = new ArrayList<>();
        ConvertEntityDTO convertEntityDTO = new ConvertEntityDTO();
        for (UsersSS usersSS: usersSSES) {
            userManagerInfoDTOS.add(convertEntityDTO.mapToUserManagerInfoDTO(usersSS));
        }

        System.out.println(usersSSES.toString());
        return  ResponseEntity.ok(userManagerInfoDTOS);
    }

    @PostMapping("/loginToken")
    public ResponseEntity<String> login(@RequestParam("username") final String username,
                                        @RequestParam("password") final String password){
        String nameuser = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(nameuser);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        if (authentication.isAuthenticated()){
            String token = jwtService.createToken(username);
            System.out.println(token);
            return ResponseEntity.ok(token);

        }else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,username));
        if (authentication.isAuthenticated()){
            String token = jwtService.createToken(username);
            System.out.println(token);
            return ResponseEntity.ok(token);

        }else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }

}

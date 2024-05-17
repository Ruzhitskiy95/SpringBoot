package com.example.springboot;

import com.example.springboot.bigtask.config.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {
    @Autowired
    Repository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/getFindAll")
    public ModelAndView findAll(){
        List<CarModel> carModels = repository.findAll();
        return new ModelAndView("findAll", "list", carModels);
    }

    @GetMapping("/getInsert")
    public String gerInsert(){

        return "insert";
    }

    @PostMapping("/insert")
    public String insertCar(@Valid @ModelAttribute CarModel carModel, BindingResult result){
        if (result.hasErrors()){
            for (ObjectError error:result.getAllErrors()){
                System.out.println(error);
            }
        }
        repository.insert(carModel);
        return "redirect:/getFindAll";
    }

    @GetMapping("/getUpdate")
    public String getUpdate(){

        return "update";
    }

        @PostMapping("/update")
    public String update(@Valid @ModelAttribute  CarModel carModel, BindingResult result){
        if (result.hasErrors()){
            for (ObjectError error:result.getAllErrors()){
                System.out.println(error);
            }
        }
            repository.update(carModel);
            return "redirect:/getFindAll";
    }

    @GetMapping("/getDelete")
    public String getDelete(){
        return "delete";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam Integer id){
        repository.deleteById(id);
        return "redirect:/getFindAll";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") final String username,
                                        @RequestParam("password") final String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        if (authentication.isAuthenticated()){
            return ResponseEntity.ok(jwtService.createToken(username));
        }else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }
}


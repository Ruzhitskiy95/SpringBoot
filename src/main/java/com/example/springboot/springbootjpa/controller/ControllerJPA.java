package com.example.springboot.springbootjpa.controller;

import com.example.springboot.springbootjpa.dao.MyCarableJPA;
import com.example.springboot.springbootjpa.model.CarModelJPA;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ControllerJPA {

    @Autowired
    private MyCarableJPA myCarableJPA;

    @GetMapping("/JPA/getFindAllJPA")
    public ModelAndView findAll(){
        List<CarModelJPA> carModels = myCarableJPA.findAll();
        return new ModelAndView("findAllJPA", "list", carModels);
    }

    @GetMapping("/JPA/getInsertJPA")
    public String gerInsert(){

        return "insertJPA";
    }

    @PostMapping("/JPA/insertJPA")
    public String insertCar(@Valid @ModelAttribute CarModelJPA carModelJPA, BindingResult result){
        if (result.hasErrors()){
            for (ObjectError error:result.getAllErrors()){
                System.out.println(error);
            }
        }
        myCarableJPA.save(carModelJPA);
        return "redirect:/JPA/getFindAllJPA";
    }

    @GetMapping("/JPA/getUpdateJPA")
    public String getUpdate(){

        return "updateJPA";
    }

        @PostMapping("/JPA/updateJPA")
    public String update(@Valid @ModelAttribute  CarModelJPA carModelJPA, BindingResult result){
        if (result.hasErrors()){
            for (ObjectError error:result.getAllErrors()){
                System.out.println(error);
            }
        }
            myCarableJPA.updateById(carModelJPA.getCarModel(),carModelJPA.getCarMounth(),carModelJPA.getCarTypeBody()
                    ,carModelJPA.getCarEngineVolume(),carModelJPA.getCarTransmission(),carModelJPA.getCarEngineVolume(),carModelJPA.getId());
            return "redirect:/JPA/getFindAllJPA";
    }

    @GetMapping("/JPA/getDeleteJPA")
    public String getDelete(){
        return "deleteJPA";
    }


    @PostMapping("/JPA/deleteJPA")
    public String delete(@RequestParam Integer id){
        myCarableJPA.deleteById(Long.valueOf(id));
        return "redirect:/JPA/getFindAllJPA";
    }

    @GetMapping("/JPA/getfindAllByCarEngineJPA")
    public ModelAndView findAllByCarEngine(){
        List<CarModelJPA> carModels = myCarableJPA.findAllByCarEngine("Diesel engine");
        return new ModelAndView("findAllJPA", "list", carModels);
    }

    @GetMapping("/JPA/findByCarMounthBetweenJPA")
    public ModelAndView findByCarMounthBetween(){
        List<CarModelJPA> carModels = myCarableJPA.findByCarMounthBetween(1990,2000);
        return new ModelAndView("findAllJPA", "list", carModels);
    }

    @GetMapping("/JPA/findByCarTransmissionJPA")
    public ModelAndView findByCarTransmission(){
        List<CarModelJPA> carModels = myCarableJPA.findByCarTransmission("Auto");
        return new ModelAndView("findAllJPA", "list", carModels);
    }
}


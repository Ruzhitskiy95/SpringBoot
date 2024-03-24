package com.example.springboot;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    Repository repository;

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
}


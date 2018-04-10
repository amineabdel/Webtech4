package edu.ap.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ap.spring.model.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

    GradeRepository repository;

    @Autowired
    public GradeController(GradeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String grade(){
        return "grade";
    }

    @RequestMapping("/list")
    public String list(Model model){

        model.addAttribute("grades", repository.findAll());

        return "list";
    }

    @PostMapping("/grade")
    public String addGrade(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("grade") int grade,
                           Model model){

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("grade", grade);
        repository.save(new Grade(firstName, lastName, grade));


        return "result";
    }

}

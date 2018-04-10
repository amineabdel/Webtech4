package edu.ap.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ap.spring.model.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

    @Autowired
    public List<Grade> grades = new ArrayList<>();

    public GradeController() {
    }

    @RequestMapping("/")
    public String grade(){
        return "grade";
    }

    @RequestMapping("/list")
    public String list(Model model){

        grades.add(new Grade("Silke", "Henderickx", 20));

        model.addAllAttributes(grades);

        System.out.println(model);

        return "list";
    }

    @PostMapping("/grade")
    public String addGrade(){



        return "result";
    }

}

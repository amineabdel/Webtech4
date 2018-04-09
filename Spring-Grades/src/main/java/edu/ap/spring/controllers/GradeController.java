package edu.ap.spring.controllers;

import edu.ap.spring.model.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GradeController {

    private List<Grade> gradeList;

    public GradeController() {

        gradeList = new ArrayList<>();

    }

    @RequestMapping(
            path="/grade",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void addGrade(@RequestBody Grade newGrade){

        gradeList.add(newGrade);

    }

}

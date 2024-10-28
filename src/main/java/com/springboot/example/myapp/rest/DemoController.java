package com.springboot.example.myapp.rest;

import com.springboot.example.myapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private Coach coach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach coach) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

}

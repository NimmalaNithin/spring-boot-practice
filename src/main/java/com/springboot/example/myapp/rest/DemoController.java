package com.springboot.example.myapp.rest;

import com.springboot.example.myapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private Coach coach;
    private Coach myCoach;

    //define a setter for dependency injection
    @Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    //define a custom method for dependency injection
//    @Autowired
//    public void doSomeStuff(Coach coach) {
//        myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }
}

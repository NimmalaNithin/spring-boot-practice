package com.springboot.example.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose '/teaminfo' endpoint that returns the injected coachName and teamName
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team Name: " + teamName;
    }


    //expose '/' endpoint that simply returns 'hello world'
    @GetMapping("/")
    public String index() {
        return "Hello World!!";
    }

    //expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkOut() {
        return  "run a hard 2k";
    }

    //expose  new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return  "Today is your lucky day";
    }
}

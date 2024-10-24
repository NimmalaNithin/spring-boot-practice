package com.springboot.example.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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

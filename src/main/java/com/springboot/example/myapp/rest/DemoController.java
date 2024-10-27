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
    private Coach myCoach;
    private Coach tCoach;
    private Coach mytCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach myCoach, @Qualifier("tennisCoach") Coach tCoach, @Qualifier("tennisCoach") Coach mytCoach) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        this.coach = coach;
        this.myCoach = myCoach;
        this.tCoach = tCoach;
        this.mytCoach = mytCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans(prototyoe): coach and myCoach, " + (coach==myCoach)+"   Comparing beans(singleton): tcoach and mytCoach, "+(tCoach==mytCoach);
    }
}

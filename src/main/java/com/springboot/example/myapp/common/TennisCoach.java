package com.springboot.example.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practical your backhand volley";
    }
}

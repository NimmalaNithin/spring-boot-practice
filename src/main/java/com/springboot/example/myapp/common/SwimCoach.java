package com.springboot.example.myapp.common;

public class SwimCoach implements Coach {
    public SwimCoach(){
        System.out.println("In constructor: SwimCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as warm up";
    }
}
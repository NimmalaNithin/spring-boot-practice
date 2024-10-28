package com.springboot.example.myapp.config;

import com.springboot.example.myapp.common.Coach;
import com.springboot.example.myapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){  //swimCoach is the bean id for SwimCoach class
        return new SwimCoach();
    }
}

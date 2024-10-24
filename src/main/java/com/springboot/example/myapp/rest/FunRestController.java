package com.springboot.example.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose '/' endpoint that simply returns 'hello world'
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}

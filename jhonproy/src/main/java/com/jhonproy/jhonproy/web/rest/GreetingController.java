package com.jhonproy.jhonproy.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingController {
    @GetMapping
    public String getGreeting(){
        return "Hola soy yo de nuevo xD";
    }
}

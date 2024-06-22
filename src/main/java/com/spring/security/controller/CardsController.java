package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {


    @GetMapping("/myCard")
    public String returnCardDetails(){
        return "Here is card details";
    }
}

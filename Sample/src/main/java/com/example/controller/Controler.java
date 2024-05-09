package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.Servicce;

@RestController
public class Controler {
  
    @Autowired
    Servicce s;

    @GetMapping("/getname")
    public String getName(@RequestParam("nm") String nameString){
        return s.getName(nameString);
    }

}

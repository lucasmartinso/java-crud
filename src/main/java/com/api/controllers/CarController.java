package com.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.CarDTO;

@RestController
@RequestMapping("/")
public class CarController {
    
    @PostMapping
    public void Car(@RequestBody CarDTO req) { 
        System.out.println(req);
        System.out.println(req.modelo());
        System.out.println(req.anoModelo());
    }
}

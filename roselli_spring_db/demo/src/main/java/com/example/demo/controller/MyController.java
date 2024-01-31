package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Persona;
import com.example.demo.repo.PersonaRepository;

@RestController
@RequestMapping("/persona")
public class MyController {
    
    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/list")
    public String list(){
        return personaRepository.findAll().toString();
    }

    @GetMapping("/{id}")
    public Persona readOne(@PathVariable("id") long id){
        return personaRepository.getById(id);
    }
    
    
}

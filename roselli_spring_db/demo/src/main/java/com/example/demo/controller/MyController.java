package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Persona;
import com.example.demo.repo.PersonaRepository;

@RestController
@RequestMapping("/persona")
public class MyController {
    
    @Autowired
    PersonaRepository personaRepository;



    //GET with request parameter
    @GetMapping("/{id}")
    public Persona readByRequest(@PathVariable long id){
        return personaRepository.getById(id);
    }

    @GetMapping("/list")
    public List<Persona> list(){
        return personaRepository.findAll();
    } 

    /*
    @GetMapping("/find")
    public Persona findByName(@RequestParam(value="name") String name){
        return personaRepository.findByName(name);
    }
     */

    @PostMapping()
    public Persona insert(@RequestBody Persona p){
        return personaRepository.save(p);
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestParam(value="id") long id){
        Persona p = personaRepository.getById(id);
        personaRepository.delete(p);
        return ResponseEntity.ok("Utente cancellato.");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Persona personaUpdated){
        Persona personaToUpdate = personaRepository.getById(id);

        personaToUpdate.setNome(personaUpdated.getNome());
        personaToUpdate.setCognome(personaUpdated.getCognome());
        personaToUpdate.setEta(personaUpdated.getEta());

        personaRepository.save(personaToUpdate);

        return ResponseEntity.ok("Dati utente aggiornati.");
    }
    
    
    
}

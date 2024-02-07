package com.example.demo.controller;
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
    @GetMapping("/search")
    public List<Persona> list(@RequestParam(name = "name", required = false) String name){
        if(name != null && name.trim().length() > 0){
            return personaRepository.findByName(name);
        }else{
            return personaRepository.findAll();
        }
    }

    @PostMapping("/insert")
    public Persona insert(@RequestBody Persona p){
        return personaRepository.save(p);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> delete(@RequestParam(value="id") long id){
        Persona p = personaRepository.getById(id);
        personaRepository.delete(p);
        return ResponseEntity.ok("Utente cancellato.");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestParam(name = "id", required = true) long id, @RequestBody Persona personaUpdated){
        Persona personaToUpdate = personaRepository.getById(id);

        personaToUpdate.setName(personaUpdated.getName());
        personaToUpdate.setSurname(personaUpdated.getSurname());
        personaToUpdate.setAge(personaUpdated.getAge());

        personaRepository.save(personaToUpdate);

        return ResponseEntity.ok("Dati utente aggiornati.");
    }
    
    
    
}

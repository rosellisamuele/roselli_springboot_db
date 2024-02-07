package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.*;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    List<Persona> findByName(String name);
}

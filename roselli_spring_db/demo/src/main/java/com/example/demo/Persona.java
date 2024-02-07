package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private int age;

    public Persona(long id, String nome, String cognome,int eta){
        this.id = id;
        this.name = nome;
        this.surname = cognome;
        this.age = eta;
    }

    public Persona(){
        this.id =  0;
        this.name = "";
        this.surname = "";
        this.age = 0;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String nome) {
        this.name = nome;
    }
    public void setSurname(String cognome) {
        this.surname = cognome;
    }
    public void setAge(int eta) {
        this.age = eta;
    }

}

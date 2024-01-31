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
    private String nome;
    private String cognome;
    private int eta;

    public Persona(long id, String nome, String cognome,int eta){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Persona(){
        this.id =  0;
        this.nome = "";
        this.cognome = "";
        this.eta = 0;
    }

    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public int getEta() {
        return eta;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }

}

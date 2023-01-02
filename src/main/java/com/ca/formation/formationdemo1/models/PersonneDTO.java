package com.ca.formation.formationdemo1.models;

import lombok.Data;

@Data
public class PersonneDTO {
    private String nom;
    private String prenom;
    private int age;
    
     public String getPrenom() {
        return prenom;
    }
    public String getNom() {
        return nom;
    }
     public int getAge() {
        return age;
    }
}

package com.ca.formation.formationdemo1.services;

import com.ca.formation.formationdemo1.exception.ResourceNotFoundException;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.models.PersonneDTO;

import java.util.List;

public interface PersonneService {

    List<Personne> getPersonnes();

    Personne getPersonne(Long id) throws ResourceNotFoundException;

    Personne updatePersonne(Long id, PersonneDTO personne) throws ResourceNotFoundException ;

    Personne addPersonne(PersonneDTO personne);

    void deletePersonne(Long id);

    List<Personne> getPersonneParNom(String nom);
}

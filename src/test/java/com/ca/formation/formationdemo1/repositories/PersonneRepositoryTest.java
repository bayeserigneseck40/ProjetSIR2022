package com.ca.formation.formationdemo1.repositories;

import com.ca.formation.formationdemo1.models.Personne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PersonneRepositoryTest {

  @Autowired
  PersonneRepository personneRepository;

  @Test
  public void ajouterPersonne() {
    Personne personne = personneRepository.save(new Personne("tonux", "samb", 50));
    assertNotNull(personne);
    assertEquals(personne.getNom(), "tonux");
  }

  // TODO: ajouter un test sur les autres methodes comme delete, findByNom, etc...


  @Test
  public void findbyNom(){

    List<Personne> person = personneRepository.findByNom("Abdel");
    assertNotNull(person);
    assertNotEquals(0, person.size());
  }

  // TODO : add test findAll



}

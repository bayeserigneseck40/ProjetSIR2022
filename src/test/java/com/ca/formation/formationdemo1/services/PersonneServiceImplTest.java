package com.ca.formation.formationdemo1.services;

import com.ca.formation.formationdemo1.exception.ResourceNotFoundException;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.repositories.PersonneRepository;
import com.ca.formation.formationdemo1.services.impl.PersonneServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonneServiceImplTest {

  @Mock
  PersonneRepository personneRepository;

  @InjectMocks
  private PersonneServiceImpl personneServiceImpl;

  Personne personne;

  @Before
  public void setUp() throws Exception {
    personne = new Personne("tonux", "samb", 50);
    personne.setId(1L);
    when(personneRepository.save(any())).thenReturn(personne);

  }

  @Test
  public void ajouterPersonne() {
    Personne personne = new Personne("tonux", "samb", 50);
    personne.setId(1L);
    when(personneRepository.save(any())).thenReturn(personne);

    Personne personneResponse = personneServiceImpl.addPersonne(new Personne("tonux", "samb", 50));

    assertNotNull(personneResponse);

    verify(personneRepository, atLeastOnce()).save(any());
  }

  // TODO: ajouter les autres tests sur methodes


  @Test
  public void updatePersonne() throws ResourceNotFoundException {

    personne.setNom("moustapha");
    given(personneRepository.findById(personne.getId())).willReturn(Optional.of(personne));
    personneServiceImpl.updatePersonne(personne.getId(), personne);
    if(Optional.of(personne).isEmpty()){
      verify(personneRepository).save(personne);
      assertEquals("moustapha",personne.getNom());
      assertEquals(1,personne.getId());
      verify(personneRepository,atLeastOnce()).save(any());
    }

  }
  @Test
  public void deletePerson() {
    when(personneRepository.findById(personne.getId())).thenReturn(Optional.of(personne));

    personneServiceImpl.deletePersonne(personne.getId());
    verify(personneRepository).deleteById(personne.getId());
  }
  @Test
  public void getPerson() throws ResourceNotFoundException {

    when(personneRepository.findById(personne.getId())).thenReturn(Optional.of(personne));

    Personne expected = personneServiceImpl.getPersonne(personne.getId());


    assertEquals("tonux", expected.getNom());
    assertEquals(1, expected.getId());
    assertThat(expected).isSameAs(personne);
    verify(personneRepository).findById(personne.getId());
  }
  @Test
  public void getAllPersons() {
    //Given
    List<Personne> list = new ArrayList<Personne>();
    list.add(new Personne("tonux","samb",50));
    list.add(new Personne("lahad","mbacke",23));
    list.add(new Personne("baye","seck",24));
    when(personneRepository.findAll()).thenReturn(list);
    //When
    List<Personne> personList = personneServiceImpl.getPersonnes();
    //Then
    assertEquals(3, personList.size());
    verify(personneRepository, atLeastOnce()).findAll();
  }

  @Test
  public void getPersonneParNom() {
    String nom="seck";
    //Given
    List<Personne> list = new ArrayList<Personne>();
    list.add(new Personne("tonux","samb",50));
    list.add(new Personne("tonux","mbacke",23));
    list.add(new Personne("baye","seck",24));
    when(personneRepository.findAll()).thenReturn(list);
    //When
    List<Personne> personList = personneServiceImpl.getPersonneParNom("tonux");
    //Then
    assertEquals(0, personList.size());
    verify(personneRepository, atLeastOnce()).findByNom("tonux");
  }

  @Test
  public void getPersonneParNomAndPrenom() {
    String nom="seck";
    String prenom="baye";
    //Given
    List<Personne> list = new ArrayList<Personne>();
    list.add(new Personne("tonux","samb",50));
    list.add(new Personne("tonux","mbacke",23));
    list.add(new Personne("seck","baye",24));
    when(personneRepository.findAll()).thenReturn(list);
    //When
    List<Personne> personList = personneServiceImpl.getPersonneParNomAndPrenom("tonux","samb");
    //Then
    assertEquals(0, personList.size());
    verify(personneRepository, atLeastOnce()).findByNomAndPrenom("tonux","samb");
  }

  @Test
  public void getPersonneNomAndPrenom() {
    String nom="seck";
    String prenom="baye";
    //Given
    List<Personne> list = new ArrayList<Personne>();
    list.add(new Personne("tonux","samb",50));
    list.add(new Personne("tonux","mbacke",23));
    list.add(new Personne("seck","baye",24));
    when(personneRepository.findAll()).thenReturn(list);
    //When
    List<Personne> personList = personneServiceImpl.getPersonneNomAndPrenom("tonux","samb");
    //Then
    assertEquals(0, personList.size());
    verify(personneRepository, atLeastOnce()).findNomPrenom("tonux","samb");
  }

  @Test
  public void getPersonneNomAndPrenom2() {
    String nom="seck";
    String prenom="baye";
    //Given
    List<Personne> list = new ArrayList<Personne>();
    list.add(new Personne("tonux","samb",50));
    list.add(new Personne("tonux","mbacke",23));
    list.add(new Personne("seck","baye",24));
    when(personneRepository.findAll()).thenReturn(list);
    //When
    List<Personne> personList = personneServiceImpl.getPersonneNomAndPrenom2("tonux","samb");
    //Then
    assertEquals(0, personList.size());
    verify(personneRepository, atLeastOnce()).findNomPrenom2("tonux","samb");
  }

  @Test
  public void ageGreaterThan() {
    //Given
    List<Personne> list = new ArrayList<Personne>();
    list.add(new Personne("tonux","samb",50));
    list.add(new Personne("tonux","mbacke",23));
    list.add(new Personne("seck","baye",24));
    when(personneRepository.findAll()).thenReturn(list);
    //When
    List<Personne> personList = personneServiceImpl.ageGreaterThan(40);
    //Then
    assertEquals(0, personList.size());
    verify(personneRepository, atLeastOnce()).ageGreaterThan(40);
  }
}

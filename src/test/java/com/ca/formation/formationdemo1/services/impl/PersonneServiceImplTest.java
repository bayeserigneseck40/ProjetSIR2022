package com.ca.formation.formationdemo1.services.impl;

import com.ca.formation.formationdemo1.exception.ResourceNotFoundException;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.repositories.PersonneRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonneServiceImplTest {

    @Mock
    private PersonneRepository personneRepository;

    @InjectMocks
    private PersonneServiceImpl personneService;

    @Test
    void updatePersonne() throws ResourceNotFoundException {
        Personne personne = new Personne("tonux", "samb", 50);
        personne.setId(1L);
        when(personneRepository.findById(1L)).thenReturn(Optional.of(personne));

        personneService.updatePersonne(1L, personne);

        verify(personneRepository).save(personne);
    }

    @Test
    void updatePersonneWhenPersonneDoesNotExistThenThrowException() {
        Long id = 1L;
        Personne personne = new Personne("nom", "prenom", 20);
        when(personneRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> personneService.updatePersonne(id, personne));

        verify(personneRepository).findById(id);
    }
}
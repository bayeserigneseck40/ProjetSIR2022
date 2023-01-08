package com.ca.formation.formationdemo1.services.impl;

import com.ca.formation.formationdemo1.models.Role;
import com.ca.formation.formationdemo1.models.Utilisateur;
import com.ca.formation.formationdemo1.repositories.UtilisateurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.xml.bind.ValidationException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UtilisateurServiceImplTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private UtilisateurServiceImpl utilisateurService;

    @Test
    void registrationWhenUsernameIsAlreadyTakenThenThrowException() {
        Utilisateur utilisateur =
                new Utilisateur("test", "test", "test", Set.of(new Role(Role.READ)));
        when(utilisateurRepository.findByUsername("test")).thenReturn(Optional.of(utilisateur));

        ValidationException exception =
                assertThrows(
                        ValidationException.class,
                        () -> utilisateurService.registration(utilisateur));

        assertEquals("Utilisateur existe deja", exception.getMessage());
    }


}
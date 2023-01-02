package com.ca.formation.formationdemo1.models;


import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UtilisateurDTO {
    private Long id;

    private boolean enabled = true;
    private String username;
    private String password;
    private String name;
    private Set<Role> authoritie = new HashSet<>();


}

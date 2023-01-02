package com.ca.formation.formationdemo1.models;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Utilisateur implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String username;
    private String password;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> authoritie = new HashSet<>();

    public Utilisateur() {
    }

    public Utilisateur(String username, String password, String name, Set<Role> authoritie) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.authoritie = authoritie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return true;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Set<Role> getAuthorities() {
        return authoritie;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getAuthoritie() {
        return authoritie;
    }

    public void setAuthoritie(Set<Role> authoritie) {
        this.authoritie = authoritie;
    }
}

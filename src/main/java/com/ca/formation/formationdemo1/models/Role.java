package com.ca.formation.formationdemo1.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
@Data
public class Role implements GrantedAuthority {

    public static final String ADMIN="ADMIN";
    public static final String READ="READ";

    private String authority;

    public Role(String authority) {
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}

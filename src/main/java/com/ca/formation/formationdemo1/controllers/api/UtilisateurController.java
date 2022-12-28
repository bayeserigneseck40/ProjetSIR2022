package com.ca.formation.formationdemo1.controllers.api;


import com.ca.formation.formationdemo1.config.jwtConfig.JwtUtil;
import com.ca.formation.formationdemo1.models.Utilisateur;
import com.ca.formation.formationdemo1.services.UtilisateurService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/auth")
public class UtilisateurController {

    private UtilisateurService utilisateurService;
    private JwtUtil jwtUtil;

    public UtilisateurController(UtilisateurService utilisateurService, JwtUtil jwtUtil) {
        this.utilisateurService = utilisateurService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Utilisateur> login(@RequestBody Utilisateur utilisateurRequest){
        try{
            Utilisateur utilisateur = utilisateurService.login(utilisateurRequest);

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtUtil.generateAccesToken(utilisateur))
                    .header("refresh_token", jwtUtil.refreshAccesToken(utilisateur))
                    .body(utilisateur);
        } catch (BadCredentialsException e){
          return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @PostMapping("/registration")
    public ResponseEntity<Utilisateur> registration(@RequestBody Utilisateur utilisateurRequest){

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

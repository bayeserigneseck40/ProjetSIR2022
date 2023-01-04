package com.ca.formation.formationdemo1.controllers.api;

import com.ca.formation.formationdemo1.exception.ResourceNotFoundException;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.models.PersonneDTO;
import com.ca.formation.formationdemo1.models.Role;
import com.ca.formation.formationdemo1.services.PersonneService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v2/personnes")
public class ApiPersonneController {

    private final PersonneService personneService;

    public ApiPersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    /**
     * - GET /api/v1/personnes
     * - POST /api/v1/personnnes
     * - PATCH /api/v1/personnnes/{id}
     * - PUT /api/v1/personnnes/{id}
     * - GET /api/v1/personnes/{id}
     * - DELETE /api/v1/personnes/{id}
     * - GET /api/v1/personnes/search?nom="Jean"
     */

    @PreAuthorize("hasAuthority('"+ Role.READ+"')")
    @GetMapping("/hello")
    public String hello(){
        return "Bonjour";
    }

    @PreAuthorize("hasAuthority('"+ Role.ADMIN+"')")
    @GetMapping("/bye")
    public  String byebye(){
        return "Bye bye";
    }

    /**
     * /api/v1/personnes
     * @return List Personne
     */
    @GetMapping
    public ResponseEntity<List<Personne>> getToutPersonne(){
        List<Personne> personnes = personneService.getPersonnes();
        return ResponseEntity.ok().body(personnes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonne(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
        Personne personne = personneService.getPersonne(id);
       return ResponseEntity.ok().body(personne);
    }

    @PostMapping
    public ResponseEntity<Personne> addPersonne(@RequestBody PersonneDTO personne){
        Personne pers =new Personne();
        pers.setPrenom(personne.getPrenom());
        pers.setNom(personne.getNom());
        pers.setAge(personne.getAge());
        Personne personneResponse = personneService.addPersonne(pers);
        return ResponseEntity.ok().body(personneResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Personne> updatePersonne(@PathVariable(value="id") Long id, @RequestBody PersonneDTO personneRequest ) throws Exception {
       Personne pers =new Personne();
       pers.setPrenom(personneRequest.getPrenom());
       pers.setNom(personneRequest.getNom());
       pers.setAge(personneRequest.getAge());
        Personne personne = personneService.updatePersonne(id, pers);

        return ResponseEntity.ok().body(personne);
    }

    @DeleteMapping("/{id}")
    public String deletePersonne(@PathVariable(value="id") Long id){
        personneService.deletePersonne(id);
        return "OK";
    }

    @GetMapping("/search")
    public ResponseEntity<List<Personne>> getPersonneParNom(@RequestParam(name = "nom") String nom){
        List<Personne> personnes = personneService.getPersonneParNom(nom);
        return ResponseEntity.ok().body(personnes);
    }



    @GetMapping("/ccc")
    public List<Personne> getPersonneParNomAndPrenom(@RequestParam(name = "nom")String nom,@RequestParam(name = "prenom")String prenom) {
        return  personneService.getPersonneParNomAndPrenom(nom,prenom);
    }

    @GetMapping("/aaa")
    public List<Personne> getPersonneNomAndPrenom(@RequestParam(name = "nom")String nom, @RequestParam(name = "prenom")String prenom) {
        return  personneService.getPersonneNomAndPrenom(nom,prenom);
    }

    @GetMapping("/bbb")
    public List<Personne> getPersonneNomAndPrenom2(@RequestParam(name = "nom")String nom,@RequestParam(name = "prenom") String prenom) {
        return  personneService.getPersonneNomAndPrenom2(nom,prenom);
    }

    @GetMapping("/age")
    public List<Personne> ageGreaterThan(@RequestParam(name = "nom") int age) {
        return  personneService.ageGreaterThan(age);
    }

}

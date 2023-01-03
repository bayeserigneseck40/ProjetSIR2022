package com.ca.formation.formationdemo1.controllers;
import com.ca.formation.formationdemo1.models.Personne;
import com.ca.formation.formationdemo1.models.PersonneDTO;
import com.ca.formation.formationdemo1.repositories.PersonneRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class PersonneController {

    private final PersonneRepository repository;

    public PersonneController(PersonneRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public String getPersonnes(Model model){
        model.addAttribute("personnes", repository.findAll());
        return "index";
    }
    @GetMapping("/nouveau")
    public String nouveauPersonne(PersonneDTO personne){
        return "nouveau";
    }

    @PostMapping("/ajouterPersonne")
    public String ajouterPersonne(PersonneDTO personne, Model model){
        Personne p = new Personne(personne.getNom(),personne.getPrenom(),personne.getAge());
        repository.save(p);
        return "redirect:/";

    }


}

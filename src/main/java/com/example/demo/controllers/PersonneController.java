package com.example.demo.controllers;

import com.example.demo.entities.Personne;
import com.example.demo.repositories.PersonneRepo;
import com.example.demo.services.Service1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created on 5/8/18 1:30 PM
 *
 * @author: salah3x
 */
@Controller
public class PersonneController {

    private final Service1 service1;
    private final PersonneRepo repo;

    public PersonneController(Service1 service1, PersonneRepo repo) {
        this.service1 = service1;
        this.repo = repo;
    }

    @GetMapping("/addPersonne")
    public String addPersonne(Model model) {
        model.addAttribute("personnes", repo.findAll());
        model.addAttribute("personne", new Personne());
        return "addPersonne";
    }

    @PostMapping("/addPersonne")
    public String addPersonnePost(Personne personne) {
        service1.ajouterPersonneAvecAdresse(personne, null);
        return "redirect:/addPersonne";
    }
}

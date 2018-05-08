package com.example.demo.controllers;

import com.example.demo.entities.Enseignant;
import com.example.demo.repositories.EnseignantRepo;
import com.example.demo.services.Service1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 5/6/18 8:46 PM
 *
 * @author: salah3x
 */
@Controller
public class EnseignantController {

    private final Service1 service1;
    private final EnseignantRepo repo;

    public EnseignantController(Service1 service1, EnseignantRepo repo) {
        this.service1 = service1;
        this.repo = repo;
    }

    @GetMapping("/addEnseignant")
    public String addEnseignant(Model model) {
        model.addAttribute("enseignants", repo.findAll());
        model.addAttribute("enseignant", new Enseignant());
        return "addEnseignant";
    }

    @PostMapping("/addEnseignant")
    public String addEnseignantPost(Enseignant enseignant, @RequestParam boolean isVacataire,
                                    @RequestParam String attribute) {
        service1.ajouterEnseignant(enseignant, isVacataire, attribute);
        return "redirect:/addEnseignant";
    }
}

package com.example.demo.controllers;

import com.example.demo.services.Service2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 5/8/18 11:56 AM
 *
 * @author: salah3x
 */
@Controller
public class AffichageController {

    private final Service2 service2;

    public AffichageController(Service2 service2) {
        this.service2 = service2;
    }

    @PostMapping("/afficherCoursAvecEtudiants")
    public String affichierCoursAvecEtudiants(@RequestParam Long cours, Model model) {
        model.addAttribute("cours", service2.afficherCoursAvecEtudiant(cours));
        return "afficherCoursAvecEtudiants";
    }

    @PostMapping("/afficherEnseignantAvecCours")
    public String afficherEnseignantAvecCours(@RequestParam Long enseignant, Model model) {
        model.addAttribute("enseignant", service2.afficherEnseignantAvecCours(enseignant));
        return "afficherEnseignantAvecCours";
    }
}

package com.example.demo.controllers;

import com.example.demo.repositories.CoursRepo;
import com.example.demo.repositories.EnseignantRepo;
import com.example.demo.repositories.EtudiantRepo;
import com.example.demo.services.Service2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 5/8/18 12:27 PM
 *
 * @author: salah3x
 */
@Controller
public class AffectationController {

    private final Service2 service2;
    private final CoursRepo coursRepo;
    private final EtudiantRepo etudiantRepo;
    private final EnseignantRepo enseignantRepo;

    public AffectationController(Service2 service2, CoursRepo coursRepo, EtudiantRepo etudiantRepo, EnseignantRepo enseignantRepo) {
        this.service2 = service2;
        this.coursRepo = coursRepo;
        this.etudiantRepo = etudiantRepo;
        this.enseignantRepo = enseignantRepo;
    }

    @GetMapping("/affecterCoursEtudiant")
    public String affecterCoursEtudiant(Model model) {
        model.addAttribute("cours", coursRepo.findAll());
        model.addAttribute("etudiants", etudiantRepo.findAll());
        return "affecterCoursEtudiant";
    }

    @PostMapping("/affecterCoursEtudiant")
    public String affecterCoursEtudiantPost(@RequestParam Long cours, @RequestParam Long etudiant) {
        service2.affecterCoursEtudiant(cours, etudiant);
        return "redirect:/affecterCoursEtudiant";
    }

    @GetMapping("/affecterCoursEnseignant")
    public String affecterCoursEnseignant(Model model) {
        model.addAttribute("cours", coursRepo.findAll());
        model.addAttribute("enseignants", enseignantRepo.findAll());
        return "affecterCoursEnseignant";
    }

    @PostMapping("/affecterCoursEnseignant")
    public String affecterCoursEnseignantPost(@RequestParam Long cours, @RequestParam Long enseignant) {
        service2.affecterCoursEnseignant(cours, enseignant);
        return "redirect:/affecterCoursEnseignant";
    }
}

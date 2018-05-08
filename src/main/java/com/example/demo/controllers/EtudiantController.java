package com.example.demo.controllers;

import com.example.demo.entities.Etudiant;
import com.example.demo.repositories.EtudiantRepo;
import com.example.demo.services.Service1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * this class will register two methods [get & post] on /etudiants
 * the get method will show the list of etudiants
 * and post will accept collect an Etudiant object from request params
 * and save it to database
 *
 * Created on 5/6/18 8:46 PM
 *
 * @author: salah3x
 */
@Controller
public class EtudiantController {

    private final Service1 service1;
    private final EtudiantRepo repo;

    public EtudiantController(Service1 service1, EtudiantRepo repo) {
        this.service1 = service1;
        this.repo = repo;
    }

    //this maps to http://{host}:{port}/addEtudiant
    @GetMapping("/addEtudiant")
    public String addEtudiant(Model model) {
        model.addAttribute("etudiants", repo.findAll());
        model.addAttribute("etudiant", new Etudiant());
        //name of template in resources/templates folder
        return "addEtudiant";
    }

    @PostMapping("/addEtudiant")
    public String addEtudiantPost(Etudiant etudiant) {
        service1.ajouterEtudiant(etudiant);
        //will send a redirect response to /addEtudiant
        return "redirect:/addEtudiant";
    }
}

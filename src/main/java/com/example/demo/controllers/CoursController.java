package com.example.demo.controllers;

import com.example.demo.entities.Cours;
import com.example.demo.repositories.CoursRepo;
import com.example.demo.services.Service1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created on 5/8/18 12:47 PM
 *
 * @author: salah3x
 */
@Controller
public class CoursController {

    private final CoursRepo repo;
    private final Service1 service1;

    public CoursController(CoursRepo repo, Service1 service1) {
        this.repo = repo;
        this.service1 = service1;
    }

    @GetMapping("/addCours")
    public String addCours(Model model) {
        model.addAttribute("cours", repo.findAll());
        model.addAttribute("cour", new Cours());
        return "addCours";
    }

    @PostMapping("/addCours")
    public String addCoursPost(Cours cours) {
        service1.ajouterCours(cours);
        return "redirect:/addCours";
    }
}

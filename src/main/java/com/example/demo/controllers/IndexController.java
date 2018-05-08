package com.example.demo.controllers;

import com.example.demo.repositories.CoursRepo;
import com.example.demo.repositories.EnseignantRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created on 5/8/18 11:45 AM
 *
 * @author: salah3x
 */
@Controller
public class IndexController {

    private final CoursRepo coursRepo;
    private final EnseignantRepo enseignantRepo;

    public IndexController(CoursRepo coursRepo, EnseignantRepo enseignantRepo) {
        this.coursRepo = coursRepo;
        this.enseignantRepo = enseignantRepo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cours", coursRepo.findAll());
        model.addAttribute("enseignants", enseignantRepo.findAll());
        return "index";
    }
}

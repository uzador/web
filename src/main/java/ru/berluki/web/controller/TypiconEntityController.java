package ru.berluki.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.berluki.web.model.TypiconEntity;
import ru.berluki.web.repository.TypiconEntityRepo;

import javax.validation.Valid;

@Controller
public class TypiconEntityController {

    private final TypiconEntityRepo typiconEntityRepo;

    @Autowired
    public TypiconEntityController(TypiconEntityRepo typiconEntityRepo) {
        this.typiconEntityRepo = typiconEntityRepo;
    }

    @GetMapping("/typiconentity")
    public String loadTypiconEntity(Model model) {
        model.addAttribute("typiconentities", typiconEntityRepo.findAll());
        return "typiconentity/index-typiconentity";
    }

    @GetMapping("/typiconentity/signup")
    public String showSignUpForm(TypiconEntity typiconEntity) {
        return "typiconentity/add-typiconentity";
    }

    @PostMapping("/typiconentity/add")
    public String addTypiconVersion(@Valid TypiconEntity typiconEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "typiconentity/add-typiconentity";
        }

        typiconEntityRepo.save(typiconEntity);
        model.addAttribute("typiconentities", typiconEntityRepo.findAll());
        return "typiconentity/index-typiconentity";
    }

    @GetMapping("/typiconentity/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        final TypiconEntity typiconEntity = typiconEntityRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid typiconentity Id:" + id));

        model.addAttribute("typiconentity", typiconEntity);
        return "typiconentity/update-typiconentity";
    }

    @PostMapping("/typiconentity/update/{id}")
    public String updateTypiconEntity(@PathVariable("id") int id, @Valid TypiconEntity typiconEntity,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            typiconEntity.setId(id);
            return "typiconentity/update-typiconentity";
        }

        typiconEntityRepo.save(typiconEntity);
        model.addAttribute("typiconentities", typiconEntityRepo.findAll());
        return "typiconentity/index-typiconentity";
    }

    @GetMapping("/typiconentity/delete/{id}")
    public String deleteTypiconEntity(@PathVariable("id") int id, Model model) {
        final TypiconEntity typiconEntity = typiconEntityRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid typiconentity Id:" + id));
        typiconEntityRepo.delete(typiconEntity);
        model.addAttribute("typiconentities", typiconEntityRepo.findAll());
        return "typiconentity/index-typiconentity";
    }
}

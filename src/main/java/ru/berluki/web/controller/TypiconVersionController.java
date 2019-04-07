package ru.berluki.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.berluki.web.model.TypiconVersion;
import ru.berluki.web.repository.TypiconVersionRepo;

import javax.validation.Valid;

@Controller
public class TypiconVersionController {

    private final TypiconVersionRepo typiconVersionRepo;

    @Autowired
    public TypiconVersionController(TypiconVersionRepo typiconVersionRepo) {
        this.typiconVersionRepo = typiconVersionRepo;
    }

    @GetMapping("/typiconversion")
    public String loadTypiconVersions(Model model) {
        model.addAttribute("typiconversions", typiconVersionRepo.findAll());
        return "typiconversion/index-typiconversion";
    }

    @GetMapping("/typiconversion/signup")
    public String showSignUpForm(TypiconVersion typiconVersion) {
        return "typiconversion/add-typiconversion";
    }

    @PostMapping("/typiconversion/add")
    public String addTypiconVersion(@Valid TypiconVersion typiconVersion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "typiconversion/add-typiconversion";
        }

        typiconVersionRepo.save(typiconVersion);
        model.addAttribute("typiconversions", typiconVersionRepo.findAll());
        return "typiconversion/index-typiconversion";
    }

    @GetMapping("/typiconversion/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        final TypiconVersion typiconVersion = typiconVersionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid typiconversion Id:" + id));

        model.addAttribute("typiconversion", typiconVersion);
        return "typiconversion/update-typiconversion";
    }

    @PostMapping("/typiconversion/update/{id}")
    public String updateTypiconVersion(@PathVariable("id") int id, @Valid TypiconVersion typiconVersion,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            typiconVersion.setId(id);
            return "typiconversion/update-typiconversion";
        }

        typiconVersionRepo.save(typiconVersion);
        model.addAttribute("typiconversions", typiconVersionRepo.findAll());
        return "typiconversion/index-typiconversion";
    }

    @GetMapping("/typiconversion/delete/{id}")
    public String deleteTypiconVersion(@PathVariable("id") int id, Model model) {
        final TypiconVersion typiconVersion = typiconVersionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid typiconversion Id:" + id));
        typiconVersionRepo.delete(typiconVersion);
        model.addAttribute("typiconversions", typiconVersionRepo.findAll());
        return "typiconversion/index-typiconversion";
    }
}

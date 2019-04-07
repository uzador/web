package ru.berluki.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.berluki.web.model.rules.Sign;
import ru.berluki.web.model.rules.TriodionRule;
import ru.berluki.web.repository.SignRepo;
import ru.berluki.web.repository.TriodionRuleRepo;
import ru.berluki.web.repository.TypiconVersionRepo;

import javax.validation.Valid;

@Controller
public class SignController {

    private final SignRepo signRepo;
    private final TypiconVersionRepo typiconVersionRepo;

    @Autowired
    public SignController(SignRepo signRepo,
                          TypiconVersionRepo typiconVersionRepo) {
        this.signRepo = signRepo;
        this.typiconVersionRepo = typiconVersionRepo;
    }

    @GetMapping("/sign")
    public String loadSigns(Model model) {
        model.addAttribute("signs", signRepo.findAll());
        return "sign/index-sign";
    }

    @GetMapping("/sign/signup")
    public String showSignUpForm(Sign sign, Model model) {
        model.addAttribute("typiconversions", typiconVersionRepo.findAll());
        return "sign/add-sign";
    }

    @PostMapping("/sign/add")
    public String addSign(@Valid Sign sign, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "sign/add-sign";
        }

        signRepo.save(sign);
        model.addAttribute("signs", signRepo.findAll());
        return "sign/index-sign";
    }

    @GetMapping("/sign/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        final Sign sign = signRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sign Id:" + id));

        model.addAttribute("sign", sign);
        model.addAttribute("typiconversions", typiconVersionRepo.findAll());
        return "sign/update-sign";
    }

    @PostMapping("/sign/update/{id}")
    public String updateSign(@PathVariable("id") int id, @Valid Sign sign,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            sign.setId(id);
            return "sign/update-sign";
        }

        signRepo.save(sign);
        model.addAttribute("signs", signRepo.findAll());
        return "sign/index-sign";
    }

    @GetMapping("/sign/delete/{id}")
    public String deleteSign(@PathVariable("id") int id, Model model) {
        final Sign sign = signRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sign Id:" + id));
        signRepo.delete(sign);
        model.addAttribute("signs", signRepo.findAll());
        return "sign/index-sign";
    }
}

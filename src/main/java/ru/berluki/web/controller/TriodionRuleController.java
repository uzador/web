package ru.berluki.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.berluki.web.model.rules.TriodionRule;
import ru.berluki.web.repository.SignRepo;
import ru.berluki.web.repository.TriodionRuleRepo;
import ru.berluki.web.repository.TypiconVersionRepo;

import javax.validation.Valid;

@Controller
public class TriodionRuleController {

    private final TriodionRuleRepo triodionRepo;
    private final TypiconVersionRepo typiconVersionRepo;
    private final SignRepo signRepo;

    @Autowired
    public TriodionRuleController(TriodionRuleRepo triodionRepo,
                                  TypiconVersionRepo typiconVersionRepo,
                                  SignRepo signRepo) {
        this.triodionRepo = triodionRepo;
        this.typiconVersionRepo = typiconVersionRepo;
        this.signRepo = signRepo;
    }

    @GetMapping("/triodionrule")
    public String loadTriodionRules(Model model) {
        model.addAttribute("triodionrules", triodionRepo.findAll());
        return "triodionrule/index-triodionrule";
    }

    @GetMapping("/triodionrule/signup")
    public String showSignUpForm(TriodionRule triodionRule, Model model) {
        model.addAttribute("typiconversions", typiconVersionRepo.findAll());
        model.addAttribute("signs", signRepo.findAll());
        return "triodionrule/add-triodionrule";
    }

    @PostMapping("/triodionrule/add")
    public String addTriodionRule(@Valid TriodionRule triodionRule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "triodionrule/add-triodionrule";
        }

        triodionRepo.save(triodionRule);
        model.addAttribute("triodionrules", triodionRepo.findAll());
        return "triodionrule/index-triodionrule";
    }

    @GetMapping("/triodionrule/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        final TriodionRule triodionRule = triodionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid triodionrule Id:" + id));

        model.addAttribute("triodionrule", triodionRule);
        model.addAttribute("typiconversions", typiconVersionRepo.findAll());
        model.addAttribute("signs", signRepo.findAll());
        return "triodionrule/update-triodionrule";
    }

    @PostMapping("/triodionrule/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid TriodionRule triodionRule,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            triodionRule.setId(id);
            return "triodionrule/update-triodionrule";
        }

        triodionRepo.save(triodionRule);
        model.addAttribute("triodionrules", triodionRepo.findAll());
        return "triodionrule/index-triodionrule";
    }

    @GetMapping("/triodionrule/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        final TriodionRule triodionRule = triodionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid triodionrule Id:" + id));
        triodionRepo.delete(triodionRule);
        model.addAttribute("triodionrules", triodionRepo.findAll());
        return "triodionrule/index-triodionrule";
    }
}

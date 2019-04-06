package ru.berluki.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.berluki.web.model.TypiconVersion;
import ru.berluki.web.model.rules.TriodionRule;
import ru.berluki.web.repository.TriodionRuleRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TriodionRuleController {

    private final TriodionRuleRepository triodionRepo;

    @Autowired
    public TriodionRuleController(TriodionRuleRepository triodionRepo) {
        this.triodionRepo = triodionRepo;
    }

    @GetMapping("/triodionrule")
    public String loadUsers(Model model) {
        final List<TriodionRule> rules = triodionRepo.findAll();
        model.addAttribute("triodionrules", triodionRepo.findAll());
        return "index-triodionrule";
    }

    @GetMapping("/triodionrule/signup")
    public String showSignUpForm(TriodionRule triodionRule) {
        return "add-triodionrule";
    }

    @PostMapping("/triodionrule/add")
    public String addTriodionRule(@Valid TriodionRule triodionRule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-triodionrule";
        }

        triodionRepo.save(triodionRule);
        model.addAttribute("triodionrules", triodionRepo.findAll());
        return "index-triodionrule";
    }

    @GetMapping("/triodionrule/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        final TriodionRule user = triodionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid triodionRule Id:" + id));

        model.addAttribute("triodionrule", user);
        return "update-triodionrule";
    }

    @PostMapping("/triodionrule/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid TriodionRule triodionRule,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            triodionRule.setId(id);
            return "update-triodionrule";
        }

        triodionRepo.save(triodionRule);
        model.addAttribute("triodionrules", triodionRepo.findAll());
        return "index-triodionrule";
    }

    @GetMapping("/triodionrule/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        final TriodionRule triodionRule = triodionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid triodionrule Id:" + id));
        triodionRepo.delete(triodionRule);
        model.addAttribute("triodionrules", triodionRepo.findAll());
        return "index-triodionrule";
    }
}

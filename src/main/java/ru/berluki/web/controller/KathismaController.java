package ru.berluki.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.berluki.web.model.Kathisma;
import ru.berluki.web.repository.KathismaRepository;

import javax.validation.Valid;

@Controller
public class KathismaController {

    private final KathismaRepository kathismaRepository;

    @Autowired
    public KathismaController(KathismaRepository kathismaRepository) {
        this.kathismaRepository = kathismaRepository;
    }

    @GetMapping("/kathisma")
    public String loadUsers(Model model) {
        model.addAttribute("kathismas", kathismaRepository.findAll());
        return "index-kathisma";
    }

    @GetMapping("/kathisma/signup")
    public String showSignUpForm(Kathisma kathisma) {
        return "add-kathisma";
    }

    @PostMapping("/kathisma/add")
    public String addUser(@Valid Kathisma kathisma, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-kathisma";
        }

        kathismaRepository.save(kathisma);
        model.addAttribute("kathismas", kathismaRepository.findAll());
        return "index-kathisma";
    }

    @GetMapping("/kathisma/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        final Kathisma kathisma = kathismaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("kathisma", kathisma);
        return "update-kathisma";
    }

    @PostMapping("/kathisma/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid Kathisma kathisma,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            kathisma.setId(id);
            return "update-kathisma";
        }

        kathismaRepository.save(kathisma);
        model.addAttribute("kathismas", kathismaRepository.findAll());
        return "index-kathisma";
    }

    @GetMapping("/kathisma/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        final Kathisma kathisma = kathismaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid kathisma Id:" + id));
        kathismaRepository.delete(kathisma);
        model.addAttribute("kathismas", kathismaRepository.findAll());
        return "index-kathisma";
    }
}

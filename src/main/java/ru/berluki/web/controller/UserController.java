package ru.berluki.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.berluki.web.model.User;
import ru.berluki.web.repository.UserRepo;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/user")
    public String loadUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "index-user";
    }

    @GetMapping("/user/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/user/add")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepo.save(user);
        model.addAttribute("users", userRepo.findAll());
        return "index-user";
    }

    @GetMapping("/user/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        final User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepo.save(user);
        model.addAttribute("users", userRepo.findAll());
        return "index-user";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        final User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepo.delete(user);
        model.addAttribute("users", userRepo.findAll());
        return "index-user";
    }
}

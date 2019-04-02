package ru.berluki.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.berluki.web.model.User;
import ru.berluki.web.repository.UserRepository;

import java.util.List;

//@RestController
//@RequestMapping(path = "/demo")
public class TestController {

    private static Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> users = userRepository.findAll();
        log.info("Users size: {}", users.size());

        return ResponseEntity.ok().body(users);
    }
}

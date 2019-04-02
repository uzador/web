package ru.berluki.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berluki.web.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

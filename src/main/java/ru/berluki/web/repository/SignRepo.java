package ru.berluki.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berluki.web.model.rules.Sign;

public interface SignRepo extends JpaRepository<Sign, Integer> {
}

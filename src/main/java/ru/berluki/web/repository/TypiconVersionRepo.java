package ru.berluki.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berluki.web.model.TypiconVersion;

public interface TypiconVersionRepo extends JpaRepository<TypiconVersion, Integer> {

}

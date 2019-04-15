package ru.berluki.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berluki.web.model.TypiconEntity;

public interface TypiconEntityRepo extends JpaRepository<TypiconEntity, Integer> {

}

package ru.berluki.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berluki.web.model.rules.TriodionRule;

public interface TriodionRuleRepo extends JpaRepository<TriodionRule, Integer> {
}

package ru.berluki.web.model.rules;

import lombok.Data;

import javax.persistence.MappedSuperclass;

//@Data
//@MappedSuperclass
public abstract class ModRuleEntity extends RuleEntity {

    protected String modRuleDefinition;
}

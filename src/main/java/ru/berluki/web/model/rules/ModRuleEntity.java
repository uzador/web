package ru.berluki.web.model.rules;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ModRuleEntity extends RuleEntity {

    protected String modRuleDefinition;

    public String getModRuleDefinition() {
        return modRuleDefinition;
    }

    public void setModRuleDefinition(String modRuleDefinition) {
        this.modRuleDefinition = modRuleDefinition;
    }
}

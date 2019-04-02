package ru.berluki.web.model.rules;

import lombok.Data;

import javax.persistence.MappedSuperclass;

//@Data
//@MappedSuperclass
public abstract class TypiconRule extends ModRuleEntity {

    protected int templateId;

    protected boolean isAddition;
}

package ru.berluki.web.model.rules;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TypiconRule extends ModRuleEntity {

    protected int templateId;

    protected byte isAddition;

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public byte getIsAddition() {
        return isAddition;
    }

    public void setIsAddition(byte isAddition) {
        this.isAddition = isAddition;
    }
}

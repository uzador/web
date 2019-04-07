package ru.berluki.web.model.rules;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TypiconRule extends ModRuleEntity {

    @ManyToOne
    @JoinColumn(name = "templateId")
    protected Sign templateId;

    protected byte isAddition;

    public Sign getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Sign templateId) {
        this.templateId = templateId;
    }

    public byte getIsAddition() {
        return isAddition;
    }

    public void setIsAddition(byte isAddition) {
        this.isAddition = isAddition;
    }
}

package ru.berluki.web.model.rules;

import javax.persistence.Entity;

@Entity
public class Sign extends ModRuleEntity {

    private byte isAddition;

    private Integer number;

    private Integer priority;

    private byte isTemplate;

    public byte getIsAddition() {
        return isAddition;
    }

    public void setIsAddition(byte isAddition) {
        this.isAddition = isAddition;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public byte getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(byte isTemplate) {
        this.isTemplate = isTemplate;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", isAddition=" + isAddition +
                ", number=" + number +
                ", priority=" + priority +
                ", isTemplate=" + isTemplate;
    }
}

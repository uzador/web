package ru.berluki.web.model.rules;

import javax.persistence.Entity;

@Entity
public class TriodionRule extends DayRule {

    private int daysFromEaster;

    //    @Column(columnDefinition = "BIT", length = 1)
//    @Type(type = "org.hibernate.type.NumericBooleanType")
    private byte isTransparent;

    public TriodionRule(int daysFromEaster, byte isTransparent) {
        this.daysFromEaster = daysFromEaster;
        this.isTransparent = isTransparent;
    }

    public TriodionRule() {
    }

    public int getDaysFromEaster() {
        return daysFromEaster;
    }

    public void setDaysFromEaster(int daysFromEaster) {
        this.daysFromEaster = daysFromEaster;
    }

    public byte getIsTransparent() {
        return isTransparent;
    }

    public void setIsTransparent(byte isTransparent) {
        this.isTransparent = isTransparent;
    }
}

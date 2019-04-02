package ru.berluki.web.model.rules;

import javax.persistence.Entity;

@Entity
public class TriodionRule extends DayRule {
    private int DaysFromEaster;

    private boolean isTransparent;

    public int getDaysFromEaster() {
        return DaysFromEaster;
    }

    public void setDaysFromEaster(int daysFromEaster) {
        DaysFromEaster = daysFromEaster;
    }

    public boolean isTransparent() {
        return isTransparent;
    }

    public void setTransparent(boolean transparent) {
        isTransparent = transparent;
    }
}

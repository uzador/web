package ru.berluki.web.model.rules;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class TriodionRule extends DayRule {

    private int daysFromEaster;

    //    @Column(columnDefinition = "BIT", length = 1)
//    @Type(type = "org.hibernate.type.NumericBooleanType")
    private byte isTransparent;
}

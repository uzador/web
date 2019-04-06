package ru.berluki.web.model.rules;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator")
public abstract class DayRule extends TypiconRule {

}

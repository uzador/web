package ru.berluki.web.model.rules;

import ru.berluki.web.model.TypiconVersion;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator")
public abstract class DayRule extends TypiconRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @ManyToOne
    @JoinColumn(name = "typiconVersionId", insertable = false, updatable = false)
    protected TypiconVersion typiconVersion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypiconVersion getTypiconVersion() {
        return typiconVersion;
    }

    public void setTypiconVersion(TypiconVersion typiconVersion) {
        this.typiconVersion = typiconVersion;
    }
}

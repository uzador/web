package ru.berluki.web.model.rules;

import ru.berluki.web.model.TypiconVersion;

import javax.persistence.*;

@MappedSuperclass
public abstract class RuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @ManyToOne
    @JoinColumn(name = "typiconVersionId")
    protected TypiconVersion typiconVersion;

    protected String ruleDefinition;

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

    public String getRuleDefinition() {
        return ruleDefinition;
    }

    public void setRuleDefinition(String ruleDefinition) {
        this.ruleDefinition = ruleDefinition;
    }
}

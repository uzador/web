package ru.berluki.web.model;

import lombok.Data;
import ru.berluki.web.model.rules.TriodionRule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Data
@Entity
public class TypiconVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String defaultLanguage;

//    @OneToMany(mappedBy = "typiconVersion", fetch = FetchType.LAZY)
//    private List<Kathisma> kathismas = new ArrayList<>();

    @OneToMany(mappedBy = "typiconVersion", fetch = FetchType.LAZY)
    private List<TriodionRule> triodionRules = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

//    public List<Kathisma> getKathismas() {
//        return kathismas;
//    }

//    public void setKathismas(List<Kathisma> kathismas) {
//        this.kathismas = kathismas;
//    }

    public List<TriodionRule> getTriodionRules() {
        return triodionRules;
    }

    public void setTriodionRules(List<TriodionRule> triodionRules) {
        this.triodionRules = triodionRules;
    }
}

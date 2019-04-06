package ru.berluki.web.model;

import lombok.Data;
import ru.berluki.web.model.rules.TriodionRule;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class TypiconVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String defaultLanguage;

    private byte isModified;

    @Column(name = "CDate")
    private LocalDateTime cdate;

    @Column(name = "BDate")
    private LocalDateTime bdate;

    @Column(name = "EDate")
    private LocalDateTime edate;

//    @OneToMany(mappedBy = "typiconVersion", fetch = FetchType.LAZY)
//    private List<Kathisma> kathismas = new ArrayList<>();

    @OneToMany(mappedBy = "typiconVersion")
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

    public List<TriodionRule> getTriodionRules() {
        return triodionRules;
    }

    public void setTriodionRules(List<TriodionRule> triodionRules) {
        this.triodionRules = triodionRules;
    }
}

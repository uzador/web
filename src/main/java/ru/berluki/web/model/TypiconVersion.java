package ru.berluki.web.model;

import org.springframework.format.annotation.DateTimeFormat;
import ru.berluki.web.model.rules.TriodionRule;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TypiconVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String defaultLanguage;

    private byte isModified;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "CDate")
    private LocalDateTime cdate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "BDate")
    private LocalDateTime bdate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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

    public byte getIsModified() {
        return isModified;
    }

    public void setIsModified(byte isModified) {
        this.isModified = isModified;
    }

    public LocalDateTime getCdate() {
        return cdate;
    }

    public void setCdate(LocalDateTime cdate) {
        this.cdate = cdate;
    }

    public LocalDateTime getBdate() {
        return bdate;
    }

    public void setBdate(LocalDateTime bdate) {
        this.bdate = bdate;
    }

    public LocalDateTime getEdate() {
        return edate;
    }

    public void setEdate(LocalDateTime edate) {
        this.edate = edate;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", defaultLanguage='" + defaultLanguage +
                ", isModified=" + isModified +
                ", cdate=" + cdate +
                ", bdate=" + bdate +
                ", edate=" + edate;
    }
}

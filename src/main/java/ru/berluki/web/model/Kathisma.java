package ru.berluki.web.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Kathisma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private TypiconVersion typiconVersion;

    private int number;
}

package ru.berluki.web.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String login;

    private String password;

    private byte isAdministrator;

    private byte isTextEditor;
}

package ru.berluki.web.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    private String login;

    private String passwordHash;

    private String email;

    private byte emailConfirmed;

    private byte twoFactorEnabled;

    private byte isAdministrator;

    private byte isTextEditor;
}

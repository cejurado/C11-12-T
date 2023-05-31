package com.delOrigen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Login {
    @Column
    private String email;
    @Column
    private String password;

}

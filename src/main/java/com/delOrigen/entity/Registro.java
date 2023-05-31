package com.delOrigen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Registro {
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private String password;
}

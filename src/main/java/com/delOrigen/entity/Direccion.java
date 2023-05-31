package com.delOrigen.entity;

import javax.persistence.*;

@Entity
public class Direccion {
    @Column
    private String calle;
    @Column
    private int numero;
    @Column
    private int piso;
    @Column
    private String departamento;
    @Column
    private String codigoPostal;
    @Column
    private String localidad;
    @Column
    private String provincia;
    @Column
    private String pais;
}


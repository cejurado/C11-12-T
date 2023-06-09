package com.delOrigen.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long id_carrito;



   // @OneToOne(cascade = CascadeType.ALL)
   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuario usuario;


    @Column
    private String direccion;

    @OneToMany(mappedBy = "id_carrito", fetch=FetchType.EAGER)
    Set<Pedido> listaPedidos = new HashSet<>();


    public Carrito(Usuario usuario, String direccion, Set<Pedido> listaPedidos) {
        this.usuario = usuario;
        this.direccion = direccion;
        this.listaPedidos = listaPedidos;
    }

    public Carrito() {

    }

    public long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(Set<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
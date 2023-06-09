package com.delOrigen.models;


import com.delOrigen.models.enumModel.Estado;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private Long numeroDeOrden;
    @Column
    private String nombreCliente;
    @Column
    private Date fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_carrito")
    private Carrito id_carrito;



    @Column
    private double costo;
    @Column
    private String formaDePago;
    @Column
    private String metodoDeEnvio;

    @Column
    private String contactoDeEnvio;
    @Column
    private String contactoDeFacturacion;
    @Column
    private Estado estado;



}

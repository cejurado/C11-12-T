package com.delOrigen.entity;

import com.delOrigen.entity.enumModel.Estado;
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
    private String Cliente;
    @Column
    private Date fecha;
    @Column
    private String formaDePago;
    @Column
    private String metodoDeEnvio;
    @Column
    private String direccionDeEnvio;
    @Column
    private String contactoDeEnvio;
    @Column
    private String contactoDeFacturacion;
    @Column
    private Estado estado;


}

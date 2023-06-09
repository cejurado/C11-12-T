package com.delOrigen.repositories;


import com.delOrigen.models.Pedido;

import java.util.List;

public interface PedidoRepository {


    List<Pedido> getPedido();


    void eliminar(Long id);

    void registrar(Pedido pedido);
}

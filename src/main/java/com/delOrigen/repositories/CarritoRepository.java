package com.delOrigen.repositories;


import com.delOrigen.models.Carrito;

import java.util.List;

public interface CarritoRepository {


    List<Carrito> getCarrito();


    void eliminar(Long id);

    void registrar(Carrito carrito);

}

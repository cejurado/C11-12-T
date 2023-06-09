package com.delOrigen.controllers;


import com.delOrigen.models.dtos.ProductoDTO;
import com.delOrigen.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoService proService;

    @RequestMapping("/productos")
    public List<ProductoDTO> getAll(){
      return proService.getAll();

    }

    @RequestMapping("/producto/{id}")
    public ProductoDTO getProducto(@PathVariable Long id){
        return proService.getAccount(id);

    }
    @PostMapping( "/producto/carga")
    public ResponseEntity<Object> cargarProducto(Authentication authentication, @PathVariable String title, @PathVariable double precio){
        return proService.cargarProducto(authentication, title,precio);
    }

}
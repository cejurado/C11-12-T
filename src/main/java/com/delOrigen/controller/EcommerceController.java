package com.delOrigen.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class EcommerceController {

    @GetMapping("/productos")
    public ArrayList<String> getAll(){
        ArrayList<String> lista= new ArrayList<String>();
        lista.add("hola Equipo");
        lista.add("la API esta online");
        return lista;
    }

}

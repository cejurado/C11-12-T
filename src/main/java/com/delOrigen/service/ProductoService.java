package com.delOrigen.service;


import com.delOrigen.models.Producto;
import com.delOrigen.models.Usuario;
import com.delOrigen.models.dtos.ProductoDTO;
import com.delOrigen.repositories.ProductoRepository;
import com.delOrigen.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class ProductoService {


    @Autowired
    private ProductoRepository accRepository;
    @Autowired
    private UsuarioRepository clRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public ProductoService() {
    }
    public List<ProductoDTO> getAll(){
        return accRepository.findAll().stream().map(a -> new ProductoDTO(a)).collect(toList());
    }

    public ProductoDTO getAccount(Long id){

        return accRepository.findById(id).map(a-> new ProductoDTO(a)).orElse(null);
    }



    public ResponseEntity<Object> cargarProducto(Authentication authentication,String title, double precio) {
        Usuario client = clRepository.findByNombre(authentication.getName());
        Set<Producto> productos = accRepository.findAll().stream().filter(p -> p.getUsuario_id() == client).collect(Collectors.toSet());

            accRepository.save(new Producto(title, "", precio, client));
            return new ResponseEntity<>("successfully ", HttpStatus.CREATED);


    }



}

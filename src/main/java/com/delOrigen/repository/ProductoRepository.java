package com.delOrigen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delOrigen.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	public Producto findByTitle(String title);

}

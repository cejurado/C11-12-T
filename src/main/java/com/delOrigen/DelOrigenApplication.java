package com.delOrigen;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.delOrigen.models.Producto;
import com.delOrigen.models.Usuario;
import com.delOrigen.repositories.ProductoRepository;
import com.delOrigen.repositories.UsuarioRepository;

@SpringBootApplication
public class DelOrigenApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean
	public CommandLineRunner initData(UsuarioRepository clRepository, ProductoRepository proRepository) {
		return (args) -> {


			Usuario cesar = new Usuario("Cesar",  "cesar@nc.com", passwordEncoder.encode("cesarpass"),true);
			Usuario eliz = new Usuario("Eliz",  "eliz@nc.com", passwordEncoder.encode("elizpass"),false);
			Usuario damian = new Usuario("Damian", "damian@nc.com", passwordEncoder.encode("damianpass"),false);
			clRepository.save(cesar);
			clRepository.save(eliz);
			clRepository.save(damian);




			Producto p1 = new Producto("Manzanas", "./img/Manzanas.jpg",  500.0, cesar);
			Producto p2 = new Producto("Peras", "./img/Pera.jpg",  300.0, cesar);
			Producto p3 = new Producto("Espinaca", "./img/Espinaca.jpg",  100.0, cesar);
			Producto p4 = new Producto("sandia", "./img/Sandia.jpg",  50.0, cesar);
			Producto p5 = new Producto("Mango", "./img/Mango.jpg",  100.0, cesar);
			Producto p6 = new Producto("Papas", "./img/Papas.jpg",  500.0, cesar);
			Producto p7 = new Producto("Bolsón Verduras 2Kg", "img/bolsonVerdura.jpeg", 2000.0,cesar);
			Producto p8 = new Producto( "Bolsón Verduras 3Kg", "img/bolsonVerdura.jpeg", 3000.0,cesar);
			Producto p9 = new Producto("Bolsón Verduras 5Kg", "img/bolsonVerdura.jpeg", 5000.0,cesar);
			Producto p10 = new Producto( "Bolsón Verduras 8Kg", "img/bolsonVerdura.jpeg", 8000.0,cesar);
			Producto p11 = new Producto( "Bolsón Frutas 2Kg", "img/bolsonFruta2.jpeg", 1000.0,cesar);
			Producto p12 = new Producto( "Bolsón Frutas 3Kg", "img/bolsonFruta2.jpeg", 1500.0,cesar);
			Producto p13 = new Producto( "Bolsón Frutas 5Kg", "img/bolsonFruta2.jpeg", 2500.0,cesar);
			Producto p14 = new Producto( "Bolsón Frutas 8Kg", "img/bolsonFruta2.jpeg", 4000.0,cesar);
			Producto p15 = new Producto( "Huevos Docena", "img/huevosBcos.jpeg", 400.0,cesar);
			Producto p16 = new Producto( "Huevos Maple", "img/maple.jpeg", 1000.0,cesar);
			Producto p17 = new Producto( "Huevos Codorniz", "img/huevosCodorniz.jpeg", 800.0,cesar);
			Producto p18 = new Producto( "Frutas Deshidratadas x 250gr", "img/bolsonFrutas1.jpeg", 900.0,cesar);
			Producto p19 = new Producto("Frutos Secos x 250gr", "img/mani.jpeg", 1250.0,cesar);
			Producto p20 = new Producto("Frutos Secos x 00gr", "img/castañas.jpeg", 2500.0,cesar);
			proRepository.save(p1);
			proRepository.save(p2);
			proRepository.save(p3);
			proRepository.save(p4);
			proRepository.save(p5);
			proRepository.save(p6);
			proRepository.save(p7);
			proRepository.save(p8);
			proRepository.save(p9);
			proRepository.save(p10);
			proRepository.save(p11);
			proRepository.save(p12);
			proRepository.save(p13);
			proRepository.save(p14);
			proRepository.save(p15);






			System.out.println(" -- carga completa de datos --");


		};
	}
	public static void main(String[] args) {
		SpringApplication.run(DelOrigenApplication.class, args);
	}

}

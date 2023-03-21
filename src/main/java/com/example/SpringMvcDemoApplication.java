package com.example;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.entities.Estudiante.Genero;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

@SpringBootApplication
public class SpringMvcDemoApplication implements CommandLineRunner{

	@Autowired
	private FacultadService facultadService;

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private TelefonoService telefonoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/**
		 * Agregar registros de muestra para Facultad,EStudiante y Telefono
		 * 
		 */


		 //Primero creamos facultades
		facultadService.save(Facultad.builder()
		
		.nombre("Informatica")
		.build());

		facultadService.save(Facultad.builder()
		.nombre("Matematicas")
		.build());
		
		//Ahora creamos estudiantes

		estudianteService.save(Estudiante.builder()
		.id(1)
		.nombre("Aurora")
		.primerApellido("Boudinot")
		.segundoApellido("Romero")
		.fechaAlta(LocalDate.of(2023, 12, 1))
		.fechaNacimiento(LocalDate.of(1993, 4, 17))
		.genero(Genero.MUJER)
		.beca(300.00)
		.facultad(facultadService.findById(2))
		.build()
		);



		estudianteService.save(Estudiante.builder()
		.id(2)
		.nombre("Cristina")
		.primerApellido("Galindo")
		.segundoApellido("Romero")
		.fechaAlta(LocalDate.of(2022, 12, 1))
		.fechaNacimiento(LocalDate.of(1993, 8, 12))
		.genero(Genero.MUJER)
		.beca(200.00)
		.facultad(facultadService.findById(1))
		.build()
		);

		//Ahora telefonos
		
		telefonoService.save(Telefono.builder()
		.id(1)
		.numero("56789090")
		.estudiante(estudianteService.findById(2))
		.build()
		);
		telefonoService.save(Telefono.builder()
		.id(2)
		.numero("5678909222")
		.estudiante(estudianteService.findById(1))
		.build()
		);
		telefonoService.save(Telefono.builder()
		.id(3)
		.numero("5678982")
		.estudiante(estudianteService.findById(1))
		.build()
		);

		
	


	}

}

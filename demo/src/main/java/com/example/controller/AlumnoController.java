package com.example.controller;

import com.example.model.Alumno;
import com.example.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping
	public ResponseEntity<List<Alumno>> obtenerTodos() {
		List<Alumno> alumnos =alumnoService.obtenerTodos();
			return ResponseEntity.ok(alumnos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Alumno> obtenerPorId(@PathVariable Long id) {
		Alumno alumno =  alumnoService.obtenerPorId(id);
		return ResponseEntity.ok(alumno);
	}

	@PostMapping
	public ResponseEntity<Alumno> crearAlumno(@Valid @RequestBody Alumno alumno) {
		Alumno nuevAlumno = alumnoService.crearAlumno(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevAlumno);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Alumno> actualizar(
		@PathVariable Long id, @Valid @RequestBody Alumno alumno) {
			Alumno actualizado = alumnoService.actualizar(id, alumno);
			return ResponseEntity.ok(actualizado);
		}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> 
	eliminarAlumno(@PathVariable Long id) {
			alumnoService.eliminarAlumno(id);
			return ResponseEntity.noContent().build();
		}
}

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class AlumnoController {

// 	public static void main(String[] args) {
// 		SpringApplication.run(AlumnoController.class, args);
// 	}

// }

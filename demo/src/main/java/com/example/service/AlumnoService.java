package com.example.service;

import com.example.exception.AlumnoException;
import com.example.model.Alumno;
import com.example.respository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    public List<Alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerPorId(Long id) {
        Optional<Alumno> alumno = alumnoRepository.findById(id);
        if (alumno.isEmpty()) {
            throw new AlumnoException("Alumno no encontrado con id:  " + id);
        }
        return alumno.get();
    }

    public Alumno crearAlumno(Alumno alumno) {
        Optional<Alumno> existente = alumnoRepository.findByTelefono(alumno.getTelefono());
        if (existente.isPresent()) {
            throw new AlumnoException("El numero ya esta registrado.");
        }
        return alumnoRepository.save(alumno);
    }

    public Alumno actualizar(Long id, Alumno alumnoActualizado) {
        Alumno alumnoExistente = obtenerPorId(id);

        if (!alumnoExistente.getTelefono().equals(alumnoActualizado.getTelefono())) {
            Optional<Alumno> alumnoConTelefono = alumnoRepository.findByTelefono(alumnoActualizado.getTelefono());
            if (alumnoConTelefono.isPresent()) {
                throw new AlumnoException("El telefono ya esta registrado.");
            }
        }


        //actualizar loscampos
        alumnoExistente.setNombre(alumnoActualizado.getNombre());
        alumnoExistente.setApellido(alumnoActualizado.getApellido());
        alumnoExistente.setTelefono(alumnoActualizado.getTelefono());
        alumnoExistente.setDireccion(alumnoExistente.getDireccion());

        return alumnoRepository.save(alumnoExistente);
    }

    public void eliminarAlumno(Long id) {
        Alumno alumno = obtenerPorId(id);
        alumnoRepository.delete(alumno);
    }
}

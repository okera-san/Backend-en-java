package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "alumnos")
public class Alumno {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 12, message = "El nombre debe tener entre 2 y 12 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    @Size(min = 2, max = 12, message = "El apellido debe tener entre 2 y 12 caracteres")
    @Column(nullable = false)
    private String apellido;

    @NotBlank(message = "El numero es requerido")
    @Pattern(regexp = "^[0-9]{8}$", message = "El numero debe tener 8 digitos")
    @Column(nullable = false, unique = true)
    private String telefono;

    @NotBlank(message = "La direccion es requerida")
    @Size(min = 4, max = 20, message = "La direccion debe tener entre 4 y 20 caracteres")
    @Column(nullable = false)
    private String direccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

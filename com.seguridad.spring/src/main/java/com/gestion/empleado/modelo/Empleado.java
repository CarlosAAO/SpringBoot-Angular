package com.gestion.empleado.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",length = 30, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 30, nullable = false)
    private String apellido;

    @Column(name = "identificacion",length = 13, nullable = false, unique = true)
    private String identificacion;

    @Column(name = "telefono",length = 13, nullable = false)
    private String telefono;

    @Column(name = "direccion",length = 50, nullable = false)
    private String direccion;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    public Empleado(){

    }

    public Empleado(Long id, String nombre, String apellido, String identificacion, String telefono, String direccion,
            String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}

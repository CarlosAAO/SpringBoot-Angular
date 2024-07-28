package com.gestion.empleado.controlador;

import com.gestion.empleado.excepciones.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.empleado.repositorio.EmpleadoRepositorio;
import com.gestion.empleado.modelo.Empleado;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoControlador{

    @Autowired
    private EmpleadoRepositorio repositorio;

    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados(){
        return repositorio.findAll();
    }

    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return repositorio.save(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
        Empleado empleado = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Id no existe"));
        ResponseEntity<Empleado> ok = ResponseEntity.ok(empleado);
        return ok;

    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
        Empleado empleado = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Id no existe"));
        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setDireccion(detallesEmpleado.getDireccion());
        empleado.setIdentificacion(detallesEmpleado.getIdentificacion());
        empleado.setTelefono(detallesEmpleado.getTelefono());
        empleado.setEmail(detallesEmpleado.getEmail());
        Empleado empleadoActualizado = repositorio.save(empleado);
        ResponseEntity<Empleado> ok = ResponseEntity.ok(empleado);
        return ok;

    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        repositorio.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

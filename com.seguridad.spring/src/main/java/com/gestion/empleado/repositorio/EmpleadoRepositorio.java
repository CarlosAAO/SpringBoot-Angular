package com.gestion.empleado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleado.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository <Empleado, Long>{

}

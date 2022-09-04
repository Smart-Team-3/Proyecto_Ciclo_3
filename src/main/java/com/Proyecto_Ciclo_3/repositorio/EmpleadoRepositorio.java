package com.Proyecto_Ciclo_3.repositorio;

import com.Proyecto_Ciclo_3.Modelo.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository <Empleado,Integer> {
}

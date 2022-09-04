package com.Proyecto_Ciclo_3.repositorio;

import com.Proyecto_Ciclo_3.Modelo.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmpleadoRepositorio extends JpaRepository <Empleado,Integer> {
    @Query(value = "SELECT * FROM empleado where empresa_id= ?1", nativeQuery = true)
    public abstract ArrayList<Empleado> findByEmpresa(Integer id);

}
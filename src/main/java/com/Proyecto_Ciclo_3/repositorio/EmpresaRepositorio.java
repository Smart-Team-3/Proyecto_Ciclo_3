package com.Proyecto_Ciclo_3.repositorio;

import com.Proyecto_Ciclo_3.Modelo.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository <Empresa,Integer>{

}

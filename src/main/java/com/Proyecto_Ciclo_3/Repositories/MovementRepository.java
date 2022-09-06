package com.Proyecto_Ciclo_3.Repositories;

import com.Proyecto_Ciclo_3.Entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository <MovimientoDinero,Integer>{

}
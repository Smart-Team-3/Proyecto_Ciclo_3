package com.Proyecto_Ciclo_3.Repositories;

import com.Proyecto_Ciclo_3.Model.Entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository <Empresa,Integer>{

}

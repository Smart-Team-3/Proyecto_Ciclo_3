package com.Proyecto_Ciclo_3.Service;


import com.Proyecto_Ciclo_3.Modelo.Entidades.Empleado;
import com.Proyecto_Ciclo_3.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {
    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRepositorio.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;

    }

    public Empleado getEmpleadoById(Integer id){
        return empleadoRepositorio.findById(id).get();

    }
    public ArrayList<Empleado> getEmpleadoByEmpresa(Integer id){
        return empleadoRepositorio.findByEmpresa(id);
    }
    public boolean saveOrUpdate(Empleado empleado) {
        Empleado empleado1 = empleadoRepositorio.save(empleado);
        if (empleadoRepositorio.findById(empleado1.getId()) !=null){
            return true;
        }
        return false;
    }

    public boolean deleteEmpleado(Integer id){
        empleadoRepositorio.deleteById(id);
        if(getEmpleadoById(id)!= null){
            return false;
                    }
        return true;
    }


}

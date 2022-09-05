package com.Proyecto_Ciclo_3.Service;


import com.Proyecto_Ciclo_3.Model.Entities.Empleado;
import com.Proyecto_Ciclo_3.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersService {
    @Autowired
    UsersRepository empleadoRepositorio;

    public List<Empleado> getAllEmpleados(){
        return this.empleadoRepositorio.findAll();
//        List<Empleado> empleadoList = new ArrayList<>();
//        empleadoRepositorio.findAll().forEach(empleado -> empleadoList.add(empleado));
//        return empleadoList;
    }

    public Empleado getEmpleadoById(Integer id){
        Optional<Empleado> empleado = empleadoRepositorio.findById(id);
        return empleado.orElse(null);
    }
//    public ArrayList<Empleado> getEmpleadoByEmpresa(Integer id){
//        return empleadoRepositorio.findByEmpresa(id);
//    }
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

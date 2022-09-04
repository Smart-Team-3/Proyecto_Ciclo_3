package com.Proyecto_Ciclo_3.Controller;


import com.Proyecto_Ciclo_3.Modelo.Entidades.Empleado;
import com.Proyecto_Ciclo_3.Modelo.Entidades.Empresa;
import com.Proyecto_Ciclo_3.Service.EmpleadoService;
import com.Proyecto_Ciclo_3.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EnterpriseController {
    @Autowired
    EmpresaService empresaService;
    @Autowired
    EmpleadoService empleadoService;
    @GetMapping ({"/","/VerEmpresas"})
    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Empresa> listaEmpresas=empresaService.getallEmpresas();
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("mensaje",mensaje);
        return "verEmpresas"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje){
        Empresa emp= new Empresa(123456);
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);
        return "agregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.setorChangeEmpresaName(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
    }

    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empresa emp=empresaService.getEmpresaById(id);
        //Creamos un atributo para el modelo, que se llame igualmente emp y es el que ira al html para llenar o alimentar campos
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje", mensaje);
        return "editarEmpresa";
    }

    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(@ModelAttribute("emp") Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.setorChangeEmpresaName(emp)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa";
    }

    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empresaService.EliminateEmpresa(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpresas";
    }
    /////
    //RestController para la entidad Empleado;
    /////
    @GetMapping("/usuarios")
    public List<Empleado> viewEmpleados(){

        return empleadoService.getAllEmpleados();
    }
    @PostMapping("/usuarios")
    public Optional<Boolean> SaveEmpleado(@RequestBody Empleado empl){
        return Optional.ofNullable(this.empleadoService.saveOrUpdate(empl));
    }
    @GetMapping(path = "/usuarios/{id}")
    public Empleado findEmmpleadoById(@PathVariable("id") Integer id){
        return this.empleadoService.getEmpleadoById(id);
    }
    @GetMapping("/Enterprises/{id}/empleados")
    public ArrayList<Empleado> FindEmpleadoByEmpresa(@PathVariable("id") Integer id){
        return this.empleadoService.getEmpleadoByEmpresa(id);
    }
    @PatchMapping("/usuarios/{id}")
    public boolean actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {
        Empleado empl = empleadoService.getEmpleadoById(id);
        empl.setNombre(empleado.getNombre());
        empl.setCorreo(empleado.getCorreo());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRol(empleado.getRol());
        return empleadoService.saveOrUpdate(empl);
    }

    @DeleteMapping("/usuarios/{id}") //Metodo para eliminar empleados por id
    public String DeleteEmpleado(@PathVariable("id") Integer id) {
        boolean respuesta = empleadoService.deleteEmpleado(id); //eliminamos usando el servicio de nuestro service
        if (respuesta) {
            return "Se elimino correctamente el empleado con id " + id;
        }
        return "No se  elimino correctamente el empleado con id "+id;
    }

}
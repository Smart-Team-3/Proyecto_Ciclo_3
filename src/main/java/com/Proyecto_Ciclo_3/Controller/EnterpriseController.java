package com.Proyecto_Ciclo_3.Controller;

import com.Proyecto_Ciclo_3.Model.Entities.Empresa;
import com.Proyecto_Ciclo_3.Service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {
    @Autowired
    EnterpriseService empresaService;

<<<<<<< HEAD
    @GetMapping ({"/","/VerEmpresas"})
    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Empresa> listaEmpresas=empresaService.getallEmpresas();
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("mensaje",mensaje);
        return "verEmpresas"; //Llamamos al HTML
=======
    @GetMapping("/enterprise")
    public List<Empresa> verEmpresas() {
        return empresaService.getallEmpresas();
>>>>>>> a630284888482fda6a568a099e7165b25f8936c4
    }

    @PostMapping("/enterprise")
    public boolean guardarEmpresa(@RequestBody Empresa empresa) {
        return this.empresaService.setorChangeEmpresaName(empresa);
    }

    @GetMapping(path = "enterprises/{id}")
    public Empresa empresaPorID(@PathVariable("id") Integer id){
        return this.empresaService.getEmpresaById(id);
    }
    @PatchMapping("/enterprises/{id}")
    public boolean actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa) {
        Empresa emp = empresaService.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());
        return empresaService.setorChangeEmpresaName(emp);
    }
        @DeleteMapping(path = "enterprises/{id}")
        public String DeleteEmpresa (@PathVariable("id") Integer id){
            boolean respuesta = this.empresaService.EliminateEmpresa(id);
            if (respuesta) {
                return "Ha sido eliminada la empresa con el id" + id;
            } else {
                return "No ha sido posible eliminar la empresa con el id" + id;
            }
        }
}
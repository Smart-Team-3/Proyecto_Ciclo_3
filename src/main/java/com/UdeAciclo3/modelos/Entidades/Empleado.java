package com.UdeAciclo3.modelos.Entidades;

import javax.persistence.*;

@Entity//entidad
@Table(name="Empleado")//para base de datos
public class Empleado {

    @Id// autoincrementable
    @GeneratedValue(strategy = GenerationType.AUTO)//estrategia
    private int id;//key
    private String nombre;
    private String correo;
    private String rol;

    @ManyToOne//asociación empleado a empresa
    @JoinColumn(name="empresa_id")//enlaza
    private Empresa empresa;//llamo a Empresa debo asociar

    //contructor vacio
    public Empleado() {
    }

    //constructor sin id
    public Empleado(String nombre, String correo, String rol, Empresa empresa) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.empresa = empresa;
    }

    //get y set
    public Empresa getEmpresa(){
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        if(rol== "administrativo"||rol=="operativo"){
            this.rol = rol;
        }else{
            System.out.println("El rol no existe");
        }
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", rol='" + rol + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Cristian Daniel
 */
public class Empleado {
    
    protected String id;
    protected String nombre;
    protected String apellido;
    protected Fecha fechaIngreso;
    protected String cargo;
    protected String StringSalarioBase;

    public Empleado() {
    }

    public Empleado(String id, String nombre, String apellido, Fecha fechaIngreso, String cargo, String StringSalarioBase) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.StringSalarioBase = StringSalarioBase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fecha fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getStringSalarioBase() {
        return StringSalarioBase;
    }

    public void setStringSalarioBase(String StringSalarioBase) {
        this.StringSalarioBase = StringSalarioBase;
    }
    
    
    
    
    
    
    
    
}

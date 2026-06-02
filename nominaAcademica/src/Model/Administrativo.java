/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Cristian Daniel
 */
public class Administrativo extends Empleado{
    private double bonoFijo;

    public Administrativo() {
    }

    public Administrativo(double bonoFijo, String id, String nombre, String apellido, Fecha fechaIngreso, String cargo, String StringSalarioBase) {
        super(id, nombre, apellido, fechaIngreso, cargo, StringSalarioBase);
        this.bonoFijo = bonoFijo;
    }

    public double getBonoFijo() {
        return bonoFijo;
    }

    public void setBonoFijo(double bonoFijo) {
        this.bonoFijo = bonoFijo;
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

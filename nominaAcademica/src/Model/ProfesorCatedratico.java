/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Cristian Daniel
 */
public class ProfesorCatedratico extends Profesor{
    private double ValorHora;
    private double horasTrabajadas;

    public ProfesorCatedratico() {
    }

    public ProfesorCatedratico(double ValorHora, double horasTrabajadas) {
        this.ValorHora = ValorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public ProfesorCatedratico(double ValorHora, double horasTrabajadas, String especialidad, String id, String nombre, String apellido, Fecha fechaIngreso, String cargo, String StringSalarioBase) {
        super(especialidad, id, nombre, apellido, fechaIngreso, cargo, StringSalarioBase);
        this.ValorHora = ValorHora;
        this.horasTrabajadas = horasTrabajadas;
    }
    

    public double getValorHora() {
        return ValorHora;
    }

    public void setValorHora(double ValorHora) {
        this.ValorHora = ValorHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Asignatura> getListaDeAsignatura() {
        return listaDeAsignatura;
    }

    public void setListaDeAsignatura(ArrayList<Asignatura> listaDeAsignatura) {
        this.listaDeAsignatura = listaDeAsignatura;
    }

    public ArrayList<Proyecto> getListaDeProyectos() {
        return listaDeProyectos;
    }

    public void setListaDeProyectos(ArrayList<Proyecto> listaDeProyectos) {
        this.listaDeProyectos = listaDeProyectos;
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

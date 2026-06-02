package Model;

import java.util.ArrayList;

/**
 *
 * @author Cristian Daniel
 */
public class ProfesorOcacional extends Profesor {

    private double horasExtra;
    private double valorHora;

    public ProfesorOcacional() {
    }

    public ProfesorOcacional(double horasExtra, double valorHora) {
        this.horasExtra = horasExtra;
        this.valorHora = valorHora;
    }

    
    public ProfesorOcacional(double horasExtra, double valorHora, String especialidad, String id, String nombre, String apellido, Fecha fechaIngreso, String cargo, String StringSalarioBase) {
        super(especialidad, id, nombre, apellido, fechaIngreso, cargo, StringSalarioBase);
        this.horasExtra = horasExtra;
        this.valorHora = valorHora;
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Cristian Daniel
 */
public class Asignatura {
    private String codigo;
    private String nombre;
    private int creditos;
    private double horas;

    @Override
    public String toString() {
        return nombre;
    }
    
    public Asignatura() {
    }

    public Asignatura(String codigo, String nombre, int creditos, double horas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas = horas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
    
    
    
    
}

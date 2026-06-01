package modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Cuidador extends Persona{
    private int nivelExperiencia;
    private String[] razas;
    private ArrayList<Fecha> disponibilidad;

    public Cuidador() {
    }

    public Cuidador(String nombre, String cedula, int nivelExperiencia, ArrayList<Fecha> disponibilidad, String[] razas) {
        super(nombre, cedula);
        this.nivelExperiencia = nivelExperiencia;
        this.disponibilidad = disponibilidad;
        this.razas = razas;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public String[] getRazas() {
        return razas;
    }

    public void setRazas(String[] razas) {
        this.razas = razas;
    }

    public ArrayList<Fecha> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(ArrayList<Fecha> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void aniadirFechaOcupado (Fecha f){
        this.disponibilidad.add(f);
    }

}

package model;

import java.util.ArrayList;

public class Usuario {
    private String nombre ;
    private String id;
    private ArrayList<Genero>listaPreferencias;
    private ArrayList<Pelicula>historialVisualizacion;
    private ArrayList<Calificacion>listaDeCalificaciones;

    public Usuario(String nombre, String id, ArrayList<Genero> listaPreferencias, ArrayList<Pelicula> historialVisualizacion) {
        this.nombre = nombre;
        this.id = id;
        this.listaPreferencias =listaPreferencias;
        this.historialVisualizacion = historialVisualizacion;
        this.listaDeCalificaciones = new ArrayList();
    }

    
    
  

    public ArrayList<Pelicula> getHistorialVisualizacion() {
        return historialVisualizacion;
    }

    public void setHistorialVisualizacion(ArrayList<Pelicula> historialVisualizacion) {
        this.historialVisualizacion = historialVisualizacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Calificacion> getLisstaDeCalificaciones() {
        return listaDeCalificaciones;
    }

    public void setLisstaDeCalificaciones(ArrayList<Calificacion> listaDeCalificaciones) {
        this.listaDeCalificaciones = listaDeCalificaciones;
    }

    public ArrayList<Genero> getListaPreferencias() {
        return listaPreferencias;
    }

    public void setListaPreferencias(ArrayList<Genero> listaPreferencias) {
        this.listaPreferencias = listaPreferencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}

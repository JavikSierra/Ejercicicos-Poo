package model;

import java.util.ArrayList;

public class Pelicula {
    private String nombre;
    private Genero genero;
    private String duracion;
    private double calificacionPromedio;
    private ArrayList<Comentario>listaDeComentarios;
    private String anio;
    private String Director;
    private int cantidadCalificaciones;

    public Pelicula() {
    }

    public Pelicula(String anio, double calificacionPromedio, String director, String duracion, Genero genero, ArrayList<Comentario> listaDeComentarios, String nombre) {
        this.anio = anio;
        this.calificacionPromedio = calificacionPromedio;
        this.Director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.listaDeComentarios = listaDeComentarios;
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ArrayList<Comentario> getListaDeComentarios() {
        return listaDeComentarios;
    }

    public void setListaDeComentarios(ArrayList<Comentario> listaDeComentarios) {
        this.listaDeComentarios = listaDeComentarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    public void promediarCalificacion(double valor){
       calificacionPromedio =
    ((calificacionPromedio * cantidadCalificaciones)
    + valor)
    / (cantidadCalificaciones + 1);

    cantidadCalificaciones++;
        
    }

    public int getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void setCantidadCalificaciones(int cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }
    

public String toString2() {

    return
    "=====================================\n" +
    "PELÍCULA\n" +
    "=====================================\n" +
    "Nombre: " + nombre + "\n" +
    "Género: " + genero + "\n" +
    "Duración: " + duracion + "\n" +
    "Calificación promedio: "
            + calificacionPromedio + "\n" +
    "Cantidad de comentarios: "
            + listaDeComentarios.size() + "\n" +
    "Año: " + anio + "\n" +
    "Director: " + Director + "\n" +
    "Cantidad de calificaciones: "
            + cantidadCalificaciones + "\n" +
    "=====================================";

}
    
    
    
    
}

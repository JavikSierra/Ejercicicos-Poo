package model;

public class Calificacion {
        private String puntuacion;
        private Pelicula pelicula;
        private Usuario usuario;

    public Calificacion() {
    }

    public Calificacion(Pelicula pelicula, String puntuacion, Usuario usuario) {
        this.pelicula = pelicula;
        this.puntuacion = puntuacion;
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

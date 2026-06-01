package model;

public class Comentario {
    private String contenido;
    private Usuario usuario;
    private Pelicula pelicula;

    public Comentario() {
    }

    public Comentario(String contenido, Usuario usuario, Pelicula pelicula) {
        this.contenido = contenido;
        this.usuario = usuario;
        this.pelicula = pelicula;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}

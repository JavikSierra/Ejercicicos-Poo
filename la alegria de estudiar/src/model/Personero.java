
package model;

public class Personero extends  Candidato{
    
    private Mascota mascota;

    public Personero(String nombre, String apellido, String grado, String lema, String numeroTarjeton, Mascota mascota, String rutaImagen) {
        this.mascota = mascota;
        super(nombre, apellido, grado, lema, numeroTarjeton, rutaImagen);
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
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

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public String getNumeroTarjeton() {
        return numeroTarjeton;
    }

    public void setNumeroTarjeton(String numeroTarjeton) {
        this.numeroTarjeton = numeroTarjeton;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

   
    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
       return nombre + " "+ apellido;
    }

    
    
    
    
    
    
    
    
}

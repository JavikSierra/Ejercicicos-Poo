
package model;


public class Mascota {
    
    
    private String nombre;
    private  int edad;
    private String genero;
    private String cualidades;
    private String id;
    private TipoMascota tipoMascota;

    public Mascota( String id, String nombre,int edad, String genero, String cualidades, TipoMascota tipoMascota) {
        this.edad = edad;
        this.nombre = nombre;
        this.genero = genero;
        this.cualidades = cualidades;
        this.id = id;
        this.tipoMascota = tipoMascota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCualidades() {
        return cualidades;
    }

    public void setCualidades(String cualidades) {
        this.cualidades = cualidades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    
    
    
    
    
}

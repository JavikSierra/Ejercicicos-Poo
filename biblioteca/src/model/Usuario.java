
package model;


public abstract class Usuario {

    protected String cc;
    protected String nombre;
    protected String direccion;
    protected String numeroTel;
    protected String codigo;

    public Usuario() {
    }

    public Usuario(String cc, String nombre, String direccion,
                   String numeroTel, String codigo) {
        this.cc = cc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroTel = numeroTel;
        this.codigo = codigo;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public abstract int calcularTiempoPrestamo();

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
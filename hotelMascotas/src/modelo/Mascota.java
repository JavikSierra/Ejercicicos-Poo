package modelo;

public class Mascota {
    private String nombre;
    private String raza;
    private int edad;
    private String necesidadesEspeciales;

    public Mascota(String nombre, String raza, int edad, String necesidadesEspeciales) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.necesidadesEspeciales = necesidadesEspeciales;
    }

    public Mascota() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNecesidadesEspeciales() {
        return necesidadesEspeciales;
    }

    public void setNecesidadesEspeciales(String necesidadesEspeciales) {
        this.necesidadesEspeciales = necesidadesEspeciales;
    }
}

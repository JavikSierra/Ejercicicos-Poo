
package model;



public class Estudiante extends Usuario {

    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String carrera, String cc, String nombre,
                      String direccion, String numeroTel, String codigo) {
        super(cc, nombre, direccion, numeroTel, codigo);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public int calcularTiempoPrestamo() {
        return 15;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Administrativo extends Usuario {

    private String dependencia;
    private String cargo;

    public Administrativo() {
    }

    public Administrativo(String dependencia, String cargo,
                          String cc, String nombre,
                          String direccion, String numeroTel,
                          String codigo) {

        super(cc, nombre, direccion, numeroTel, codigo);
        this.dependencia = dependencia;
        this.cargo = cargo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public int calcularTiempoPrestamo() {
        return 3;
    }
}
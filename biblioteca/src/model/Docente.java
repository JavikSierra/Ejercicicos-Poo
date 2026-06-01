/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Docente extends Usuario {

    private String departamento;

    public Docente() {
    }

    public Docente(String departamento, String cc, String nombre,
                   String direccion, String numeroTel, String codigo) {
        super(cc, nombre, direccion, numeroTel, codigo);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public int calcularTiempoPrestamo() {
        return 15;
    }
}
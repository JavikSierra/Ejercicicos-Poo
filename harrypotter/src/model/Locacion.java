/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jose Angarita
 */
package model;

public class Locacion {

    private String nombre;
    private String descripcion;
    private String secreto;

    public Locacion(String nombre, String descripcion, String secreto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.secreto = secreto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSecreto() {
        return secreto;
    }

    public void setSecreto(String secreto) {
        this.secreto = secreto;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
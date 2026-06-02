/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 */
public abstract class Personaje {

    protected String nombre;
    protected int edad;
    protected String personalidad;
    protected String rol;

    public Personaje() {}

    public Personaje(String nombre, int edad, String personalidad, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String hablar(String mensaje) {
        return nombre + ": " + mensaje;
    }

    public String mover(String direccion) {
        return nombre + " se mueve hacia " + direccion;
    }


    public String interactuar(Personaje obj) {
        return nombre + " interactúa con " + obj.getNombre();
    }
    
    @Override
public String toString() {
    return nombre;
}
}

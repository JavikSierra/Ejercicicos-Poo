/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 */
public class Chavo extends Personaje {

    public Chavo() {
        super("El Chavo", 8, "Inocente y travieso", "Protagonista");
    }

    public Chavo(String nombre, int edad, String personalidad, String rol) {
        super(nombre, edad, personalidad, rol);
    }

    public String pedirTortaJamon() {
        return nombre + " pide una torta de jamón";
    }
}
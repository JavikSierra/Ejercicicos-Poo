/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *

 */
public class Quico extends Personaje {

    public Quico() {
        super("Quico", 9, "Engreído y consentido", "Vecino");
    }

    public Quico(String nombre, int edad, String personalidad, String rol) {
        super(nombre, edad, personalidad, rol);
    }

    public String llorar() {
        return nombre + " empieza a llorar";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 */
public class DoniaFlorinda extends Personaje {

    public DoniaFlorinda() {
        super("Doña Florinda", 40, "Autoritaria y sobreprotectora", "Madre de Quico");
    }

    public DoniaFlorinda(String nombre, int edad, String personalidad, String rol) {
        super(nombre, edad, personalidad, rol);
    }

    public String darBofetada() {
        return nombre + " le da una bofetada a Don Ramón";
    }
}

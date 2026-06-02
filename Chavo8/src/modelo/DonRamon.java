/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author vicen
 */
public class DonRamon extends Personaje {

    public DonRamon() {
        super("Don Ramón", 45, "Perezoso pero simpático", "Vecino endeudado");
    }

    public DonRamon(String nombre, Integer edad, String personalidad, String rol) {
        super(nombre, edad, personalidad, rol);
    }

    public String evadirCobroRenta() {
        return nombre + " evade el cobro de la renta del Señor Barriga";
    }
}

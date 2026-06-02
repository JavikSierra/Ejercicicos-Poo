/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 */
public class Casa extends ObjetoInteractivo {

    private int numero;
    private String propietario;

    public Casa(int numero, String propietario) {
        super("Casa " + numero, "Casa de " + propietario);
        this.numero = numero;
        this.propietario = propietario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String entrar() {
        return "Entrando a la casa número " + numero + " del propietario " + propietario;
    }
}
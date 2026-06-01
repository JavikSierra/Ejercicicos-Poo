/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Daniel
 */
public class Bosque {
    private double tamaño;
    private Arbol arbol;
    private Casa casa;

    public Bosque() {
    }

    public Bosque(double tamaño, Arbol arbol, Casa casa) {
        this.tamaño = tamaño;
        this.arbol = arbol;
        this.casa = casa;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
    public void describir(){ 
        JOptionPane.showMessageDialog(null, "El bosque susurra con el viento");
    }
    public void cortarArboles(){
        JOptionPane.showMessageDialog(null, "Los árboles se mecieron suavemente");
    }
    
    
    
}

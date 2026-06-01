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
public class Abuela extends Personaje{
    private int edad;
    private String estadoDeSalud;

    public Abuela() {
    }

    public Abuela(int edad, String estadoDeSalud) {
        this.edad = edad;
        this.estadoDeSalud = estadoDeSalud;
    }

    public Abuela(int edad, String estadoDeSalud, String nombbre, boolean vivo) {
        super(nombbre, vivo);
        this.edad = edad;
        this.estadoDeSalud = estadoDeSalud;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoDeSalud() {
        return estadoDeSalud;
    }

    public void setEstadoDeSalud(String estadoDeSalud) {
        this.estadoDeSalud = estadoDeSalud;
    }

    public String getNombbre() {
        return nombbre;
    }

    public void setNombbre(String nombbre) {
        this.nombbre = nombbre;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    public void recibirVisita(){
        
    }

    @Override
   public void hablar() {
    JOptionPane.showMessageDialog(null, "Hola, soy la abuela");
}

@Override
public void moverse() {
    JOptionPane.showMessageDialog(null, "La abuela se movió lentamente hacia la cama");
}

    
    
    
}

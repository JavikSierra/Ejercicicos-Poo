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
public class Lobo extends Personaje{
    private boolean disfrazado;

    public Lobo() {
    }

    public Lobo(boolean disfrazado) {
        this.disfrazado = disfrazado;
    }

    public Lobo(boolean disfrazado, String nombbre, boolean vivo) {
        super(nombbre, vivo);
        this.disfrazado = disfrazado;
    }
    public void correr(){
        
    }
    public void engañar(){
        
    }
    public void disfrazarse(){
        
    }

    @Override
   public void hablar() {
    JOptionPane.showMessageDialog(null, "Soy el lobo, ¿a dónde vas?");
}

@Override
public void moverse() {
    JOptionPane.showMessageDialog(null, "El lobo se movió sigilosamente entre los árboles");
}

    
    
    
    
    
    
    
}

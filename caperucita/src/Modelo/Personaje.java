/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cristian Daniel
 */
public abstract class Personaje {
    protected String nombbre;
    protected boolean vivo;

    public Personaje() {
    }

    public Personaje(String nombbre, boolean vivo) {
        this.nombbre = nombbre;
        this.vivo = vivo;
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
    
    
    
    public abstract void hablar();
    public abstract void moverse();
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Copia {

    private int idCopia;
    private boolean disponible;
   

    public Copia() {
    }

    public Copia(int idCopia) {
        this.idCopia = idCopia;
        this.disponible = true;
        
    }

    public int getIdCopia() {
        return idCopia;
    }

    public void setIdCopia(int idCopia) {
        this.idCopia = idCopia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    @Override
    public String toString() {
        return  String.valueOf(idCopia);
    }
    
    
}
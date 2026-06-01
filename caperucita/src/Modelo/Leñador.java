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
public class Leñador extends Personaje{
    private boolean tieneHacha;

    public Leñador() {
    }

    public boolean isTieneHacha() {
        return tieneHacha;
    }

    public void setTieneHacha(boolean tieneHacha) {
        this.tieneHacha = tieneHacha;
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
    public void recatar(){
        
    }
    public void abrirLobo(){}
    public void salvar(){}
    public void llenarDePiedras(){}

    @Override
   public void hablar() {
    JOptionPane.showMessageDialog(null, "Soy el cazador, vengo a ayudar");
    }

@Override
    public void moverse() {
    JOptionPane.showMessageDialog(null, "El cazador entró rápidamente a la casa de la abuela");
    }

    
}

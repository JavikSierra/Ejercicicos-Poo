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
public class Caperucita extends Personaje{
    private String colorCapa;
    private Cesta cesta;

    public Caperucita() {
    }

    public Caperucita(String colorCapa, Cesta cesta) {
        this.colorCapa = colorCapa;
        this.cesta = cesta;
    }

    public Caperucita(String colorCapa, Cesta cesta, String nombbre, boolean vivo) {
        super(nombbre, vivo);
        this.colorCapa = colorCapa;
        this.cesta = cesta;
    }

    public String getColorCapa() {
        return colorCapa;
    }

    public void setColorCapa(String colorCapa) {
        this.colorCapa = colorCapa;
    }

    public Cesta getCesta() {
        return cesta;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
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

    @Override
    public void hablar() {
    JOptionPane.showMessageDialog(null, "Hola, soy Caperucita Roja");
}

@Override
public void moverse() {
    JOptionPane.showMessageDialog(null, "Caperucita caminó alegremente por el bosque");
}

    public void visitarAbuela(){
    
    }
    public void entregarCesta(){
        
    }
    
    
    
}

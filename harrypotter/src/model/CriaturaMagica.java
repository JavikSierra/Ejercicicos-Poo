/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jose Angarita
 */
public class CriaturaMagica extends Personaje {

    public CriaturaMagica(String id, String nombre,
            CasaTipo casa, int nivelMagia) {

        super(id,nombre,casa,nivelMagia);
    }

    public void atacar(Estudiante e){
        System.out.println(nombre + " ataca a "
                + e.getNombre());
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public CasaTipo getCasa() {
        return casa;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public int getVida() {
        return vida;
    }
    
    
    
}
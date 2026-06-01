/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Profesor extends Personaje {

    private ArrayList<ClaseMagica> clases;

    public Profesor(String id, String nombre,
            CasaTipo casa, int nivelMagia) {

        super(id,nombre,casa,nivelMagia);
        clases = new ArrayList<>();
    }

    public void enseñarHechizo(Estudiante e, Hechizo h){
        e.aprenderHechizo(h);
    }

    public ArrayList<ClaseMagica> getClases() {
        return clases;
    }

    public void setClases(ArrayList<ClaseMagica> clases) {
        this.clases = clases;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CasaTipo getCasa() {
        return casa;
    }

    public void setCasa(CasaTipo casa) {
        this.casa = casa;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
    
}

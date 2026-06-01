/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jose Angarita
 */
public abstract class Personaje {

    protected String id;
    protected String nombre;
    protected CasaTipo casa;
    protected int nivelMagia;
    protected int vida;

    public Personaje(String id, String nombre, CasaTipo casa, int nivelMagia) {
        this.id = id;
        this.nombre = nombre;
        this.casa = casa;
        this.nivelMagia = nivelMagia;
        this.vida = 100;
    }

    public void hablar() {
        System.out.println(nombre + " está hablando");
    }

    public void moverse() {
        System.out.println(nombre + " se mueve");
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

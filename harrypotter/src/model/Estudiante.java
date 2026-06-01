/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Estudiante extends Personaje {

    private ArrayList<Hechizo> hechizos;
    private ArrayList<ObjetoMagico> objetos;
    private ArrayList<Locacion> locacionesVisitadas;

    public Estudiante(String id, String nombre,
            CasaTipo casa, int nivelMagia) {

        super(id, nombre, casa, nivelMagia);

        hechizos = new ArrayList<>();
        objetos = new ArrayList<>();
        locacionesVisitadas = new ArrayList<>();
    }

    public void aprenderHechizo(Hechizo h){
        hechizos.add(h);
    }

    public void usarHechizo(Hechizo h){
        System.out.println(nombre + " usa " + h.getNombre());
    }

    public void agregarObjeto(ObjetoMagico o){
        objetos.add(o);
    }

    public void visitarLocacion(Locacion l){
        locacionesVisitadas.add(l);
    }

    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(ArrayList<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public ArrayList<ObjetoMagico> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<ObjetoMagico> objetos) {
        this.objetos = objetos;
    }

    public ArrayList<Locacion> getLocacionesVisitadas() {
        return locacionesVisitadas;
    }

    public void setLocacionesVisitadas(ArrayList<Locacion> locacionesVisitadas) {
        this.locacionesVisitadas = locacionesVisitadas;
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

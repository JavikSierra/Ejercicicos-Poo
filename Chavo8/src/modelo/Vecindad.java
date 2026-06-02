/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 */
public class Vecindad {

    private ArrayList<Personaje> personajes = new ArrayList<>();
    private ArrayList<ObjetoInteractivo> objetos = new ArrayList<>();

    public Vecindad() {
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public ArrayList<ObjetoInteractivo> getObjetos() {
        return objetos;
    }

    public void agregarPersonaje(Personaje p) {
        personajes.add(p);
    }

    public void agregarObjeto(ObjetoInteractivo obj) {
        objetos.add(obj);
    }

    public String mostrarPersonajes() {
        String resultado = "Personajes en la vecindad:\n";

        for (Personaje p : personajes) {
            resultado += p.getNombre() + "\n";
        }

        return resultado;
    }

    public String mostrarObjetos() {
        String resultado = "Objetos en la vecindad:\n";

        for (ObjetoInteractivo o : objetos) {
            resultado += o.getNombre() + "\n";
        }

        return resultado;
    }
}

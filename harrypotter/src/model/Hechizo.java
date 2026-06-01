/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jose Angarita
 */
public class Hechizo {

    private String nombre;
    private String uso;
    private String id;

    public Hechizo(String nombre,
            String uso,
            String id) {

        this.nombre = nombre;
        this.uso = uso;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
}

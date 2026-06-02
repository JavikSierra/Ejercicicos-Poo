/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 */
public class Barril extends ObjetoInteractivo {

    private String material;

    public Barril() {
    }

    public Barril(String material, String nombre, String descripcion) {
        super(nombre, descripcion);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String usar() {
        return nombre + " está siendo usado como escondite";
    }
}

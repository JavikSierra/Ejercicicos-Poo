/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cristian Daniel
 */
public class Retacgulo extends Cuadrilatero {
    
    public Retacgulo(double lado1, double lado2, double lado3, double lado4) {
        super(lado1, lado2, lado3, lado4);
    }

    @Override
    public double caluclarPerimetro() {
        return 2 * (getLado1() + getLado2());
    }

    @Override
    public double caluclarArea() {
        return getLado1() * getLado2();
    }
}

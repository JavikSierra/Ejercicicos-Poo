/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cristian Daniel
 */
public class Cuadrado extends Cuadrilatero{
    
    public Cuadrado(double lado1, double lado2, double lado3, double lado4) {
        super(lado1, lado2, lado3, lado4);
    }
    
    
    
    @Override
    public double caluclarPerimetro() {
        double perimetro=getLado1()*4;
        return perimetro;
    }

    @Override
    public double caluclarArea() {
        double Area=getLado1()*lado1;
        return Area;
    }
   
}

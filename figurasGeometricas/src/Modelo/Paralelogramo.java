
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Cristian Daniel
 */
public class Paralelogramo extends Cuadrilatero {
    
    private double altura;

    public Paralelogramo(double lado1, double lado2, double lado3, double lado4, double altura) {
        super(lado1, lado2, lado3, lado4);
        this.altura = altura;
    }

    @Override
    public double caluclarPerimetro() {
        return getLado1() + getLado2() + getLado3() + getLado4();
    }

    @Override
    public double caluclarArea() {
        return getLado1() * altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
}

package Modelo;

/**
 *
 * @author Cristian Daniel
 */
public class Trapecio extends Cuadrilatero {

    private double altura;

    public Trapecio(double lado1, double lado2, double lado3, double lado4, double altura) {
        super(lado1, lado2, lado3, lado4);
        this.altura = altura;
    }

    @Override
    public double caluclarPerimetro() {
        return getLado1() + getLado2() + getLado3() + getLado4();
    }

    @Override
    public double caluclarArea() {
        return ((getLado1() + getLado3()) / 2) * altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

package Modelo;

/**
 *
 * @author Cristian Daniel
 */
public class Rombo extends Cuadrilatero {
    
    private double diagonalMayor;
    private double diagonalMenor;

    public Rombo(double lado1, double lado2, double lado3, double lado4, double diagonalMayor, double diagonalMenor) {
        super(lado1, lado2, lado3, lado4);
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public double caluclarPerimetro() {
        return getLado1() * 4;
    }

    @Override
    public double caluclarArea() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public void setDiagonalMayor(double diagonalMayor) {
        this.diagonalMayor = diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    public void setDiagonalMenor(double diagonalMenor) {
        this.diagonalMenor = diagonalMenor;
    }
}

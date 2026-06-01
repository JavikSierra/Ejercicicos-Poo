/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;

/**
 *
 * @author User
 */
public class LibroColeccionGeneral extends Libro {

    
   
    public LibroColeccionGeneral() {
    }

    public LibroColeccionGeneral(String titulo, String autor,
                           String issn, int anio,
                           String editorial) {
        super(titulo, autor, issn, anio, editorial);
    }

    @Override
    public boolean validarCantidadCopias() {
        return copias.size() >= 1;
    }
}
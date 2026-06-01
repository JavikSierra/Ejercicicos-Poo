/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Libro {

    protected String titulo;
    protected String autor;
    protected String issn;
    protected int anio;
    protected String editorial;

    protected List<Copia> copias;

    public Libro() {
        copias = new ArrayList<>();
    }

    public Libro(String titulo, String autor, String issn,
                 int anio, String editorial) {

        this.titulo = titulo;
        this.autor = autor;
        this.issn = issn;
        this.anio = anio;
        this.editorial = editorial;
        this.copias = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public List<Copia> getCopias() {
        return copias;
    }

    public void setCopias(List<Copia> copias) {
        this.copias = copias;
    }

    public void agregarCopia(Copia copia) {
        copias.add(copia);
    }

    public abstract boolean validarCantidadCopias();

    @Override
    public String toString() {
        return titulo;
    }
    
    
}
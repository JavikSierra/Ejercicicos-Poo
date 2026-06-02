package Model;

import java.util.ArrayList;

public class Proyecto {

    private String codigo;
    private String descripcion;
    private ArrayList<Producto> listaDeProductos;

    public Proyecto() {
        listaDeProductos = new ArrayList<>();
    }

    public Proyecto(String codigo, String descripcion, ArrayList<Producto> listaDeProductos) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.listaDeProductos = listaDeProductos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(ArrayList<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    @Override
    public String toString() {
        return codigo;
    }
}
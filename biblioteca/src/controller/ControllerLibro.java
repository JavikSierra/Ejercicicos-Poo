/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.*;
import view.*;

/**
 *
 * @author User
 */
public class ControllerLibro {
    
    private JFLibro frmLibro;
   private ArrayList<Libro> listaLibros;

    public ControllerLibro(JFLibro frmLibro) {
        this.frmLibro = frmLibro;
        this.listaLibros = new ArrayList();
        initEvents();
    }

    private void initEvents() {
        
      this.frmLibro.btnEliminar.addActionListener(e->eliminar());
      this.frmLibro.btnRegistrar.addActionListener(e->registrar());
      this.frmLibro.btnModificar.addActionListener(e->modificar());
      this.frmLibro.btnLimpiar.addActionListener(e->limpiar());
      this.frmLibro.txtConsultar.addActionListener(e->buscarPorTitulo());
      this.frmLibro.btnCopia.addActionListener(e->agregarCopia());
       cargarLibrosPredeterminados();
    }

   private void eliminar() {

    int fila = frmLibro.tableLibros.getSelectedRow();

    if(fila >= 0){
        listaLibros.remove(fila);
        actualizarTabla();
    }
}

   private void modificar() {

    int fila = frmLibro.tableLibros.getSelectedRow();

    if(fila < 0){
        return;
    }

    Libro libro = listaLibros.get(fila);

    libro.setTitulo(frmLibro.txtTitulo.getText());
    libro.setAutor(frmLibro.txtAutor.getText());
    libro.setIssn(frmLibro.txtIssn.getText());
    libro.setAnio(Integer.parseInt(frmLibro.txtAño.getText()));
    libro.setEditorial(frmLibro.txtEditorial.getText());
    
    actualizarTabla();
    limpiar();
}

   private void registrar() {
       

     
String titulo = frmLibro.txtTitulo.getText().trim();
String autor = frmLibro.txtAutor.getText().trim();
String issn = frmLibro.txtIssn.getText().trim();
String editorial = frmLibro.txtEditorial.getText().trim();

if(titulo.isEmpty() ||
   autor.isEmpty() ||
   issn.isEmpty() ||
   frmLibro.txtAño.getText().trim().isEmpty() ||
   editorial.isEmpty()){

    javax.swing.JOptionPane.showMessageDialog(
            frmLibro,
            "Debe completar todos los campos"
    );

    return;
}

int año = Integer.parseInt(frmLibro.txtAño.getText());
    Libro libro = null;

    switch(frmLibro.cmbTipo.getSelectedItem().toString()) {

        case "Referencia":
            libro = new LibroReferencia(
                    titulo,
                    autor,
                    issn,
                    año,
                    editorial);
            break;

        case "Coleccion General":
            libro = new LibroColeccionGeneral(
                    titulo,
                    autor,
                    issn,
                    año,
                    editorial);
            break;
    }

    if(libro != null){
        listaLibros.add(libro);
        actualizarTabla();
        limpiar();
    }
}

  private void limpiar() {

    frmLibro.txtTitulo.setText("");
    frmLibro.txtAutor.setText("");
    frmLibro.txtIssn.setText("");
    frmLibro.txtAño.setText("");
    frmLibro.txtEditorial.setText("");

    frmLibro.cmbTipo.setSelectedIndex(0);
}

   private void buscarPorTitulo() {

    String tituloBuscar =
            frmLibro.txtConsultar.getText().toLowerCase();

    javax.swing.table.DefaultTableModel modelo =
            (javax.swing.table.DefaultTableModel)
            frmLibro.tableLibros.getModel();

    modelo.setRowCount(0);

    for (Libro l : listaLibros) {

        if (l.getTitulo().toLowerCase().contains(tituloBuscar)) {

            modelo.addRow(new Object[]{
                l.getTitulo(),
                l.getAutor(),
                l.getIssn(),
                l.getAnio(),
                l.getEditorial(),
                l.getClass().getSimpleName(),
                l.getCopias().size()
            });
        }
    }
}

  private void agregarCopia() {

    int fila = frmLibro.tableLibros.getSelectedRow();

    if (fila == -1) {

        javax.swing.JOptionPane.showMessageDialog(
                frmLibro,
                "Seleccione un libro"
        );

        return;
    }

    Libro libro = listaLibros.get(fila);

    if (libro instanceof LibroReferencia &&
        libro.getCopias().size() >= 2) {

        javax.swing.JOptionPane.showMessageDialog(
                frmLibro,
                "Un libro de referencia solo puede tener 2 copias"
        );

        return;
    }

    int numeroCopia = libro.getCopias().size() + 1;

    Copia copia = new Copia(
            numeroCopia
    );

    libro.getCopias().add(copia);

    actualizarTabla();

    javax.swing.JOptionPane.showMessageDialog(
            frmLibro,
            "Copia registrada correctamente"
    );
}
    
    
    
    public void actualizarTabla() {

    javax.swing.table.DefaultTableModel modelo =
            (javax.swing.table.DefaultTableModel)
            frmLibro.tableLibros.getModel();

    modelo.setRowCount(0);

    for (Libro l : listaLibros) {

        modelo.addRow(new Object[]{
            l.getTitulo(),
            l.getAutor(),
            l.getIssn(),
            l.getAnio(),
            l.getEditorial(),
            l.getClass().getSimpleName(),
            l.getCopias().size()
        });
    }
}
    
private void cargarLibrosPredeterminados() {

    Libro libro;

    libro = new LibroColeccionGeneral("Java Fundamentos", "Deitel", "1001", 2020, "Pearson");
    for(int i=1;i<=3;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Programacion Orientada a Objetos", "Booch", "1002", 2019, "McGraw Hill");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Estructuras de Datos", "Weiss", "1003", 2021, "Pearson");
    for(int i=1;i<=4;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Bases de Datos", "Elmasri", "1004", 2022, "Pearson");
    for(int i=1;i<=3;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Redes de Computadores", "Tanenbaum", "1005", 2020, "Prentice Hall");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Sistemas Operativos", "Silberschatz", "1006", 2021, "Wiley");
    for(int i=1;i<=3;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Algoritmos", "Cormen", "1007", 2018, "MIT Press");
    for(int i=1;i<=5;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Desarrollo Web", "Freeman", "1008", 2023, "O'Reilly");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Python para Todos", "Severance", "1009", 2021, "Coursera");
    for(int i=1;i<=3;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroColeccionGeneral("Inteligencia Artificial", "Russell", "1010", 2022, "Pearson");
    for(int i=1;i<=4;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    // REFERENCIA

    libro = new LibroReferencia("Ingenieria de Software", "Pressman", "2001", 2021, "McGraw Hill");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("Patrones de Diseño", "Gamma", "2002", 2019, "Addison Wesley");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("Compiladores", "Aho", "2003", 2018, "Pearson");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("Arquitectura de Computadores", "Patterson", "2004", 2020, "Morgan Kaufmann");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("Matematicas Discretas", "Rosen", "2005", 2022, "McGraw Hill");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("Calculo Diferencial", "Stewart", "2006", 2021, "Cengage");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("Fisica Universitaria", "Serway", "2007", 2020, "Cengage");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("Estadistica Aplicada", "Levin", "2008", 2019, "Pearson");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("Analisis y Diseño de Sistemas", "Kendall", "2009", 2021, "Pearson");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    libro = new LibroReferencia("UML y Modelado", "Fowler", "2010", 2018, "Addison Wesley");
    for(int i=1;i<=2;i++) libro.getCopias().add(new Copia(i));
    listaLibros.add(libro);

    actualizarTabla();
}

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }
    
    
    
    
}

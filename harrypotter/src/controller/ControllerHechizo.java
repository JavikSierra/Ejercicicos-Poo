/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.Escuela;
import model.Hechizo;
import view.JFHechizo;

public class ControllerHechizo implements ActionListener {

    private JFHechizo vista;
    private Escuela escuela;

    public ControllerHechizo(JFHechizo vista, Escuela escuela) {

        this.vista = vista;
        this.escuela = escuela;

        vista.btnRegistrar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);

        cargarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnRegistrar) {
            registrar();
        }

        if (e.getSource() == vista.btnEliminar) {
            eliminar();
        }

        if (e.getSource() == vista.btnModificar) {
            modificar();
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    private void registrar() {

        String id = vista.txtId.getText();
        String nombre = vista.txtNombre.getText();
        String uso = vista.txtUso.getText();

        Hechizo h = new Hechizo(id, nombre, uso);

        escuela.agregarHechizo(h);

        cargarTabla();
        limpiar();
    }

    private void eliminar() {

        int fila = vista.tablePersonajes.getSelectedRow();

        if (fila >= 0) {

            escuela.getHechizos().remove(fila);

            cargarTabla();
            limpiar();
        }
    }

    private void modificar() {

        int fila = vista.tablePersonajes.getSelectedRow();

        if (fila >= 0) {

            Hechizo h = escuela.getHechizos().get(fila);

            h.setId(vista.txtId.getText());
            h.setNombre(vista.txtNombre.getText());
            h.setUso(vista.txtUso.getText());

            cargarTabla();
            limpiar();
        }
    }

    private void cargarTabla() {

        DefaultTableModel modelo =
                (DefaultTableModel) vista.tablePersonajes.getModel();

        modelo.setRowCount(0);

        for (Hechizo h : escuela.getHechizos()) {

            modelo.addRow(new Object[]{
                h.getNombre(),
                h.getId(),
                h.getUso()
            });
        }
    }

    private void limpiar() {

        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtUso.setText("");
    }
}
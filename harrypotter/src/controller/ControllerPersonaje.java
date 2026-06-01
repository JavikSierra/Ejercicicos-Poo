package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.Escuela;
import model.Estudiante;
import model.*;
import view.JFPersonnaje;

public class ControllerPersonaje implements ActionListener {

    private JFPersonnaje vista;
    private Escuela escuela;

    public ControllerPersonaje(JFPersonnaje vista, Escuela escuela) {

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

        CasaTipo casa = (CasaTipo) vista.cmbCasa.getSelectedItem();

        int nivelMagia = Integer.parseInt(vista.txtNivelMagia.getText());
        int vida = Integer.parseInt(vista.txtVida.getText());

        Estudiante estudiante =
                new Estudiante(id, nombre, casa, nivelMagia);

        estudiante.setVida(vida);

        escuela.agregarEstudiante(estudiante);

        cargarTabla();
        limpiar();
    }

    private void eliminar() {

        int fila = vista.tablePersonaje.getSelectedRow();

        if (fila >= 0) {

            escuela.getEstudiantes().remove(fila);

            cargarTabla();
            limpiar();
        }
    }

    private void modificar() {

        int fila = vista.tablePersonaje.getSelectedRow();

        if (fila >= 0) {

            Estudiante e = escuela.getEstudiantes().get(fila);

            e.setId(vista.txtId.getText());
            e.setNombre(vista.txtNombre.getText());
            e.setCasa( (CasaTipo)vista.cmbCasa.getSelectedItem());
            e.setNivelMagia(
                    Integer.parseInt(vista.txtNivelMagia.getText()));
            e.setVida(
                    Integer.parseInt(vista.txtVida.getText()));

            cargarTabla();
        }
    }

    private void cargarTabla() {

        DefaultTableModel modelo =
                (DefaultTableModel) vista.tablePersonaje.getModel();

        modelo.setRowCount(0);

        for (Estudiante e : escuela.getEstudiantes()) {

            modelo.addRow(new Object[]{
                e.getId(),
                e.getNombre(),
                e.getCasa(),
                e.getNivelMagia(),
                e.getVida(),
                "Estudiante"
            });
        }
    }

    private void limpiar() {

        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtNivelMagia.setText("");
        vista.txtVida.setText("");

        vista.cmbTipo.setSelectedIndex(0);

        if (vista.cmbCasa.getItemCount() > 0) {
            vista.cmbCasa.setSelectedIndex(0);
        }

        if (vista.cmbHechizos.getItemCount() > 0) {
            vista.cmbHechizos.setSelectedIndex(0);
        }
    }
}
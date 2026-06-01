/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.ClaseMagica;
import model.Escuela;
import model.Estudiante;
import model.Hechizo;
import model.Profesor;
import view.JFClases;

public class ControllerClases implements ActionListener {

    private JFClases vista;
    private Escuela escuela;

    public ControllerClases(JFClases vista, Escuela escuela) {

        this.vista = vista;
        this.escuela = escuela;

        vista.btnHechizo.addActionListener(this);

        cargarCombos();
        cargarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnHechizo) {
            registrarClase();
        }
    }

    private void registrarClase() {

        Profesor profesor =
                (Profesor) vista.cmbProfesor.getSelectedItem();

        Estudiante estudiante =
                (Estudiante) vista.cmbEstudiante.getSelectedItem();

        Hechizo hechizo =
                (Hechizo) vista.cmbHechizo.getSelectedItem();

        String tema = vista.txtTema.getText();

        ClaseMagica clase =
                new ClaseMagica(profesor, estudiante, hechizo, tema);

        escuela.agregarClase(clase);

        cargarTabla();
        limpiar();
    }

    private void cargarCombos() {

        vista.cmbProfesor.removeAllItems();
        vista.cmbEstudiante.removeAllItems();
        vista.cmbHechizo.removeAllItems();

        for (Profesor p : escuela.getProfesores()) {
            vista.cmbProfesor.addItem(p);
        }

        for (Estudiante e : escuela.getEstudiantes()) {
            vista.cmbEstudiante.addItem(e);
        }

        for (Hechizo h : escuela.getHechizos()) {
            vista.cmbHechizo.addItem(h);
        }
    }

    private void cargarTabla() {

        DefaultTableModel modelo =
                (DefaultTableModel) vista.tablePersonajes.getModel();

        modelo.setRowCount(0);

        for (ClaseMagica c : escuela.getClases()) {

            modelo.addRow(new Object[]{
                c.getProfesor().getNombre(),
                c.getTema(),
                c.getEstudiante().getNombre(),
                c.getHechizo().getNombre()
            });
        }
    }

    private void limpiar() {

        vista.txtTema.setText("");

        if (vista.cmbProfesor.getItemCount() > 0) {
            vista.cmbProfesor.setSelectedIndex(0);
        }

        if (vista.cmbEstudiante.getItemCount() > 0) {
            vista.cmbEstudiante.setSelectedIndex(0);
        }

        if (vista.cmbHechizo.getItemCount() > 0) {
            vista.cmbHechizo.setSelectedIndex(0);
        }
    }
}

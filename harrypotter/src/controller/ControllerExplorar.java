package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Escuela;
import model.Estudiante;
import model.Locacion;
import view.JFExplorar;

public class ControllerExplorar implements ActionListener {

    private JFExplorar vista;
    private Escuela escuela;

    public ControllerExplorar(JFExplorar vista, Escuela escuela) {

        this.vista = vista;
        this.escuela = escuela;

        vista.btnExplorar.addActionListener(this);
        vista.btnSecreto.addActionListener(this);

        cargarCombos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnExplorar) {
            explorar();
        }

        if (e.getSource() == vista.btnSecreto) {
            descubrirSecreto();
        }
    }

    private void cargarCombos() {

        vista.cmbEstudiante.removeAllItems();
        vista.cmbLocacion.removeAllItems();

        for (Estudiante est : escuela.getEstudiantes()) {
            vista.cmbEstudiante.addItem(est);
        }

        for (Locacion loc : escuela.getLocaciones()) {
            vista.cmbLocacion.addItem(loc);
        }
    }

    private void explorar() {

        Estudiante estudiante =
                (Estudiante) vista.cmbEstudiante.getSelectedItem();

        Locacion locacion =
                (Locacion) vista.cmbLocacion.getSelectedItem();

        if (estudiante == null || locacion == null) {
            return;
        }

        vista.areaResults.setText(
                "ESTUDIANTE: " + estudiante.getNombre()
                + "\n\nLOCACION VISITADA: " + locacion.getNombre()
                + "\n\nDESCRIPCION:"
                + "\n" + locacion.getDescripcion()
        );
    }

    private void descubrirSecreto() {

        Locacion locacion =
                (Locacion) vista.cmbLocacion.getSelectedItem();

        if (locacion == null) {
            return;
        }

        vista.areaResults.append(
                "\n\n===== SECRETO DESCUBIERTO ====="
                + "\n" + locacion.getSecreto()
        );
    }
}
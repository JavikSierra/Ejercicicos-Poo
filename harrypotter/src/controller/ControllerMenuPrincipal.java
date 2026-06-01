/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Escuela;
import view.JFClases;
import view.JFHechizo;
import view.JFMenuPrincipal;
import view.JFObjetos;
import view.JFPersonnaje;

public class ControllerMenuPrincipal implements ActionListener {

    private JFMenuPrincipal vista;
    private Escuela escuela;

    public ControllerMenuPrincipal(JFMenuPrincipal vista, Escuela escuela) {

        this.vista = vista;
        this.escuela = escuela;

        vista.btnEstudiantes.addActionListener(this);
        vista.btnHechizos.addActionListener(this);
        vista.btnObjetos.addActionListener(this);
        vista.btnHogwarts.addActionListener(this);
        vista.btnClasesMagicas.addActionListener(this);
        vista.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnEstudiantes) {

            JFPersonnaje frm = new JFPersonnaje();
            new ControllerPersonaje(frm, escuela);

            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        }

        if (e.getSource() == vista.btnHechizos) {

            JFHechizo frm = new JFHechizo();
            new ControllerHechizo(frm, escuela);

            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        }

        if (e.getSource() == vista.btnObjetos) {

            JFObjetos frm = new JFObjetos();
            new ControllerObjetos(frm, escuela);

            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        }

        if (e.getSource() == vista.btnHogwarts) {

            JOptionPane.showMessageDialog(
                    null,
                    "Explorar Hogwarts aún no implementado");
        }

        if (e.getSource() == vista.btnClasesMagicas) {

            JFClases frm = new JFClases();
            new ControllerClases(frm, escuela);

            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        }

        if (e.getSource() == vista.btnSalir) {

            System.exit(0);
        }
    }
}

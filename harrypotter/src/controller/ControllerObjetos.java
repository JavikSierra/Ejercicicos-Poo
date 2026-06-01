/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Escuela;
import model.ObjetoMagico;
import view.JFObjetos;

public class ControllerObjetos implements ActionListener {

    private JFObjetos vista;
    private Escuela escuela;

    public ControllerObjetos(JFObjetos vista, Escuela escuela) {

        this.vista = vista;
        this.escuela = escuela;

        vista.btnRegistrar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnLimpiar1.addActionListener(this);

        mostrarObjetos();
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

        if (e.getSource() == vista.btnLimpiar1) {
            buscar();
        }
    }

    private void registrar() {

        try {

            String nombre = vista.txtNombre.getText();
            String proposito = vista.txtProposito.getText();
            int nivel = Integer.parseInt(vista.txtNivelObj.getText());

            ObjetoMagico objeto =
                    new ObjetoMagico(nombre, proposito, nivel);

            escuela.agregarObjeto(objeto);

            mostrarObjetos();
            limpiar();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null,
                    "Datos inválidos");
        }
    }

    private void eliminar() {

        String nombre = vista.txtNombre.getText();

        for (int i = 0; i < escuela.getObjetos().size(); i++) {

            if (escuela.getObjetos().get(i)
                    .getNombre().equalsIgnoreCase(nombre)) {

                escuela.getObjetos().remove(i);

                JOptionPane.showMessageDialog(null,
                        "Objeto eliminado");

                mostrarObjetos();
                limpiar();
                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Objeto no encontrado");
    }

    private void modificar() {

        String nombre = vista.txtNombre.getText();

        for (ObjetoMagico o : escuela.getObjetos()) {

            if (o.getNombre().equalsIgnoreCase(nombre)) {

                o.setProposito(vista.txtProposito.getText());

                o.setNivelObjeto(
                        Integer.parseInt(
                                vista.txtNivelObj.getText()));

                JOptionPane.showMessageDialog(null,
                        "Objeto modificado");

                mostrarObjetos();
                limpiar();
                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Objeto no encontrado");
    }

    private void buscar() {

        String nombre = vista.txtNombre.getText();

        for (ObjetoMagico o : escuela.getObjetos()) {

            if (o.getNombre().equalsIgnoreCase(nombre)) {

                vista.txtProposito.setText(o.getProposito());
                vista.txtNivelObj.setText(
                        String.valueOf(o.getNivelObjeto()));

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Objeto no encontrado");
    }

    private void mostrarObjetos() {

        String texto = "";

        for (ObjetoMagico o : escuela.getObjetos()) {

            texto += "Nombre: " + o.getNombre()
                    + "\nProposito: " + o.getProposito()
                    + "\nNivel: " + o.getNivelObjeto()
                    + "\n---------------------------\n";
        }

        vista.areaMostrar.setText(texto);
    }

    private void limpiar() {

        vista.txtNombre.setText("");
        vista.txtProposito.setText("");
        vista.txtNivelObj.setText("");
    }
}

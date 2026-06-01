/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;
import view.JFRegistrarFormula;

/**
 *
 * @author Jose Angarita
 */
public class ControllerFormula {
    private JFRegistrarFormula frmFormula;
    private ArrayList<Estudiante> listaFormulas;
    private ControllerRegistrarCandidato controller;

    public ControllerFormula(JFRegistrarFormula frmFormula, ControllerRegistrarCandidato controller) {
       this.controller= controller;
        this.frmFormula = frmFormula;
        this.listaFormulas = new ArrayList<>();

        initEvents();
    }

    private void initEvents() {

        this.frmFormula.btnRegistrar
                .addActionListener(e -> registrar());

        this.frmFormula.btnEliminar
                .addActionListener(e -> eliminar());
    }

    private void registrar() {

        try {

            // VALIDAR CAMPOS VACIOS
            if (frmFormula.txtNombre.getText().trim().isEmpty()
                    || frmFormula.txtApellido.getText().trim().isEmpty()
                  ) {

                JOptionPane.showMessageDialog(null,
                        "Todos los campos son obligatorios");

                return;
            }

            // OBTENER DATOS
            String nombre =
                    frmFormula.txtNombre.getText().trim();

            String apellido =
                    frmFormula.txtApellido.getText().trim();

           
            
           
            // VALIDAR SI YA EXISTE
            for (Estudiante e : listaFormulas) {

                if (e.getNombre().equalsIgnoreCase(nombre)
                        && e.getApellido().equalsIgnoreCase(apellido)) {

                    JOptionPane.showMessageDialog(null,
                            "La formula ya existe");

                    return;
                }
            }

            // CREAR OBJETO
            Estudiante formula = new Estudiante(
                    nombre,
                    apellido
            );

            // AGREGAR
            listaFormulas.add(formula);

            JOptionPane.showMessageDialog(null,
                    "Formula registrada correctamente");

            limpiarCampos();
            this.controller.habilitarPanel();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error al registrar");
        }
    }

    private void eliminar() {

        String nombreBuscar =
                frmFormula.txtNombre.getText().trim();

        String apellidoBuscar =
                frmFormula.txtApellido.getText().trim();

        // VALIDAR
        if (nombreBuscar.isEmpty()
                || apellidoBuscar.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Ingrese nombre y apellido");

            return;
        }

        Estudiante formulaEliminar = null;

        // BUSCAR
        for (Estudiante e : listaFormulas) {

            if (e.getNombre().equalsIgnoreCase(nombreBuscar)
                    && e.getApellido().equalsIgnoreCase(apellidoBuscar)) {

                formulaEliminar = e;
                break;
            }
        }

        // VALIDAR SI EXISTE
        if (formulaEliminar == null) {

            JOptionPane.showMessageDialog(null,
                    "Formula no encontrada");

            return;
        }

        // ELIMINAR
        listaFormulas.remove(formulaEliminar);

        JOptionPane.showMessageDialog(null,
                "Formula eliminada correctamente");

        limpiarCampos();
        
    }

    private void limpiarCampos() {

        frmFormula.txtNombre.setText("");
        frmFormula.txtApellido.setText("");
      
    }

    public ArrayList<Estudiante> getListaFormulas() {
        return listaFormulas;
    }
    
}
    

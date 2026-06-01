/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.*;

/**
 *
 * @author User**/



public class ControllerPrincipal {

    private JFPrincipal frmPrincipal;
    private JFUsuario frmUsuario;
    private JFLibro frmLibro;
    private JFPrestamos frmPrestamos;

    private ControllerUsuario controllerUsuario;
    private ControllerLibro controllerLibro;
    private ControllerPrestamos controlPrestamos;

    public ControllerPrincipal(JFPrincipal frmPrincipal) {

        this.frmPrincipal = frmPrincipal;

        this.frmUsuario = new JFUsuario();
        this.frmLibro = new JFLibro();
        this.frmPrestamos= new JFPrestamos();

        this.controllerUsuario = new ControllerUsuario(frmUsuario, this);
        this.controllerLibro = new ControllerLibro(frmLibro);
        this.controlPrestamos= new ControllerPrestamos(frmPrestamos,controllerLibro, controllerUsuario);

        initEvents();
    }

    private void initEvents() {

        this.frmPrincipal.btnUsuarios.addActionListener(
                e -> abrirUsuarios());

        this.frmPrincipal.btnLibros2.addActionListener(
                e -> abrirLibros());

        this.frmPrincipal.btnSalir.addActionListener(
                e -> salir());
        this.frmPrincipal.btnPrestamos.addActionListener(e->abrirPrestamos());

    }

    private void abrirUsuarios() {

        this.frmUsuario.setLocationRelativeTo(null);
        this.frmUsuario.setVisible(true);

    }

    private void abrirLibros() {

        this.frmLibro.setLocationRelativeTo(null);
        this.frmLibro.setVisible(true);

    }

    private void salir() {

        System.exit(0);

    }
     private void abrirPrestamos() {

        this.frmPrestamos.setLocationRelativeTo(null);
        this.frmPrestamos.setVisible(true);

    }

    public ControllerPrestamos getControlPrestamos() {
        return controlPrestamos;
    }
     
     
     

}

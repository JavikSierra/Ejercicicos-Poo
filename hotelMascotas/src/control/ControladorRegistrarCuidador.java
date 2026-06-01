package control;

import modelo.Cuidador;
import vista.JFRegistrarCuidador;

import javax.swing.*;
import java.util.ArrayList;

public class ControladorRegistrarCuidador {
    private JFRegistrarCuidador frmCuidador;
    private ArrayList<Cuidador> listaCuidadores;

    public ControladorRegistrarCuidador(JFRegistrarCuidador frmcuidador) {
        this.frmCuidador = frmcuidador;
        this.listaCuidadores = new ArrayList<>();
        initEvents();
    }

    private void initEvents() {
        this.frmCuidador.btnRegistrarCuidador.addActionListener(e -> Registrar());
    }

    public void Registrar() {
        String nombre = this.frmCuidador.txtNombreCuidador.getText();
        String cedula = this.frmCuidador.txtCedula.getText();
        String raza = this.frmCuidador.txtRazasManejo.getText().trim();
        String nivelExpStr = this.frmCuidador.txtNivelDeExperiencia.getText();

        if (nombre.isEmpty() || cedula.isEmpty() || raza.isEmpty() || nivelExpStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos incompletos, operacion no realizada");
        }

        else  {
            int nivelExp = Integer.parseInt(nivelExpStr);
            String [] razas = raza.split("/");
            Cuidador cuidador = new Cuidador(nombre,cedula,nivelExp,new ArrayList<>(),razas);
            listaCuidadores.add(cuidador);
            JOptionPane.showMessageDialog(null, "Cuidador Registrado Correctamente");
            this.frmCuidador.dispose();
        }
    }

    public ArrayList<Cuidador> getListaCuidadores() {
        return listaCuidadores;
    }
}

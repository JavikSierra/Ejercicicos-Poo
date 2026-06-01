package control;

import modelo.Cliente;
import modelo.Mascota;
import vista.JFRegistrarDuenoMascota;

import javax.swing.*;
import java.util.ArrayList;

public class ControladorRegistrarDuenoMascota {
    private JFRegistrarDuenoMascota frmDuenoMascota;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Mascota> listaMascotas;

    public ControladorRegistrarDuenoMascota() {}

    public ControladorRegistrarDuenoMascota(JFRegistrarDuenoMascota frmDuenoMascota) {
        this.frmDuenoMascota = frmDuenoMascota;
        this.listaClientes = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
        initEvents();
    }

    private void initEvents() {
        this.frmDuenoMascota.btnRegistrar.addActionListener(e ->registrarDuenoMascota());
    }

    public void registrarDuenoMascota (){

        String nombreDueno = this.frmDuenoMascota.txtNombreDueno.getText();
        String cedulaDueno = this.frmDuenoMascota.txtCedula.getText();
        String telefonoDueno = this.frmDuenoMascota.txtTelefono.getText();

        String nombreMascota = this.frmDuenoMascota.txtNombreMacota.getText();
        String raza = this.frmDuenoMascota.txtRaza.getText();
        String edadStr = this.frmDuenoMascota.txtEdad.getText();
        String nescesidades = this.frmDuenoMascota.txtNecesidades.getText();


        if (nombreDueno.isEmpty()|| cedulaDueno.isEmpty()|| telefonoDueno.isEmpty()|| nombreMascota.isEmpty()||raza.isEmpty()||nescesidades.isEmpty()||edadStr.isEmpty()){
            JOptionPane.showMessageDialog(null, "Datos incompletos, operacion no realizada");
        }

        else if (!verificarCedula(cedulaDueno)){
            JOptionPane.showMessageDialog(null, "Ya exixte un Cliente con esa Cedula, operacion no realizada");
        }

        else {

            int edad = Integer.parseInt(edadStr);
            Mascota mascota = new Mascota (nombreMascota,raza,edad,nescesidades);
            listaMascotas.add(mascota);

            Cliente cliente = new Cliente (nombreDueno,cedulaDueno,telefonoDueno,listaMascotas.getLast(),null);
            listaClientes.add(cliente);
            JOptionPane.showMessageDialog(null, "Cliente "+nombreDueno+" y su mascota "+nombreMascota+" Registrado correctamente");
            this.frmDuenoMascota.dispose();
        }
    }

    public boolean verificarCedula (String cedula){
        for (Cliente d: listaClientes){
            if (d.getCedula().equals(cedula)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }
}

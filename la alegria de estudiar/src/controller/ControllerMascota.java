
package controller;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import view.JFRegistrarMascota;
import model.*;

public class ControllerMascota {
    
    private JFRegistrarMascota frmMascota;
    private ArrayList<Mascota> listaMascotas;
    private ControllerRegistrarCandidato control;
    
    public ControllerMascota(JFRegistrarMascota frmMascota, ControllerRegistrarCandidato control) {
        this.frmMascota = frmMascota;
        this.listaMascotas = new ArrayList();
        this.control= control;
        initEvents();
    }

    private void initEvents() {
      
        this.frmMascota.btnEliminar.addActionListener(e->eliminar());
        this.frmMascota.btnRegistrar.addActionListener(e->registrar());
        this.frmMascota.cmbTipo.setModel(new DefaultComboBoxModel<>(TipoMascota.values()));
    }

    private void eliminar() {
       String idBuscar = frmMascota.txtId.getText().trim();

        // VALIDAR
        if (idBuscar.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Ingrese el ID de la mascota");

            return;
        }

        Mascota mascotaEliminar = null;

        // BUSCAR
        for (Mascota m : listaMascotas) {

            if (m.getId().equalsIgnoreCase(idBuscar)) {

                mascotaEliminar = m;
                break;
            }
        }

        // VALIDAR SI EXISTE
        if (mascotaEliminar == null) {

            JOptionPane.showMessageDialog(null,
                    "Mascota no encontrada");

            return;
        }

        // ELIMINAR
        listaMascotas.remove(mascotaEliminar);

        JOptionPane.showMessageDialog(null,
                "Mascota eliminada correctamente");

        limpiarCampos();
    }

    private void registrar() {
    
           try {

            // VALIDAR CAMPOS VACIOS
            if (frmMascota.txtId.getText().trim().isEmpty()
                    || frmMascota.txtNombre.getText().trim().isEmpty()
                    || frmMascota.txtEdad.getText().trim().isEmpty()
                    || frmMascota.txtGenero.getText().trim().isEmpty()
                    || frmMascota.txtCualidades.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Todos los campos son obligatorios");

                return;
            }

            // OBTENER DATOS
            String id = frmMascota.txtId.getText().trim();
            String nombre = frmMascota.txtNombre.getText().trim();

            int edad = Integer.parseInt(
                    frmMascota.txtEdad.getText().trim());

            String genero = frmMascota.txtGenero.getText().trim();

            String cualidades =
                    frmMascota.txtCualidades.getText().trim();

            TipoMascota tipo =
                    (TipoMascota) frmMascota.cmbTipo.getSelectedItem();

            // VALIDAR EDAD
            if (edad < 0) {

                JOptionPane.showMessageDialog(null,
                        "La edad no puede ser negativa");

                return;
            }

            // VALIDAR ID REPETIDO
            for (Mascota m : listaMascotas) {

                if (m.getId().equalsIgnoreCase(id)) {

                    JOptionPane.showMessageDialog(null,
                            "Ya existe una mascota con ese ID");

                    return;
                }
            }

            // CREAR OBJETO
            Mascota mascota = new Mascota(
                    id,
                    nombre,
                    edad,
                    genero,
                    cualidades,
                    tipo
            );

            // GUARDAR
            listaMascotas.add(mascota);

            JOptionPane.showMessageDialog(null,
                    "Mascota registrada correctamente");

            limpiarCampos();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null,
                    "La edad debe ser numérica");
        }
        
        this.control.habilitarPanel();
        
        
    }
    
    
    private void limpiarCampos() {

        frmMascota.txtId.setText("");
        frmMascota.txtNombre.setText("");
        frmMascota.txtEdad.setText("");
        frmMascota.txtGenero.setText("");
        frmMascota.txtCualidades.setText("");
        frmMascota.cmbTipo.setSelectedIndex(0);
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }
    
    
}

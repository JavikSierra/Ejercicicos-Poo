/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.*;
import view.*;
/**
 *
 * @author User
 */
public class ControllerUsuario {
    
   private JFUsuario frmUsuario;
   private ArrayList<Usuario> listaUsuarios;
   private ControllerPrincipal controlPrincipal;

    public ControllerUsuario(JFUsuario frmUsuario,ControllerPrincipal controlPrincipal ) {
        this.frmUsuario = frmUsuario;
        this.listaUsuarios = new ArrayList();
        this.controlPrincipal=controlPrincipal;
        initEvents();
    }

    private void initEvents() {
        
      this.frmUsuario.btnEliminar.addActionListener(e->eliminar());
      this.frmUsuario.btnRegistrar.addActionListener(e->registrar());
      this.frmUsuario.cmbTipo.addActionListener(e->cambiarTipo());
      this.frmUsuario.btnModificar.addActionListener(e->modificar());
      this.frmUsuario.btnLimpiar.addActionListener(e->limpiar());
      
    }

    private void eliminar() {

    int fila = frmUsuario.tableUsuarios.getSelectedRow();

    if (fila >= 0) {
        listaUsuarios.remove(fila);
        actualizarTabla();
    }
}

    private void registrar() {

    String cc = frmUsuario.txtCC1.getText();
    String nombre = frmUsuario.txtNombre.getText();
    String direccion = frmUsuario.txtDireccion.getText();
    String telefono = frmUsuario.txtTelefono.getText();
    String codigo = frmUsuario.txtCodigo.getText();
    String dato = frmUsuario.txtDato.getText();

    
    if(cc.isEmpty() ||
   nombre.isEmpty() ||
   direccion.isEmpty() ||
   telefono.isEmpty() ||
   codigo.isEmpty() ||
   dato.isEmpty() ||
   frmUsuario.cmbTipo.getSelectedIndex() == 0){

    javax.swing.JOptionPane.showMessageDialog(
            frmUsuario,
            "Complete todos los campos"
    );

    return;
}
    
    
    
    Usuario usuario = null;

    switch (frmUsuario.cmbTipo.getSelectedItem().toString()) {

        case "Estudiante":
            usuario = new Estudiante(dato, cc, nombre,
                    direccion, telefono, codigo);
            break;

        case "Docente":
            usuario = new Docente(dato, cc, nombre,
                    direccion, telefono, codigo);
            break;

        case "Administrativo":
            usuario = new Administrativo(
                    dato,
                    "",
                    cc,
                    nombre,
                    direccion,
                    telefono,
                    codigo
            );
            break;
    }

    if (usuario != null) {
        listaUsuarios.add(usuario);
        actualizarTabla();
        controlPrincipal.getControlPrestamos().actualizarCombos();
        limpiar();
        
    }
}

    private void cambiarTipo() {

             String tipo = frmUsuario.cmbTipo.getSelectedItem().toString();

    switch (tipo) {

        case "Estudiante":
            frmUsuario.lblDato.setText("Carrera:");
            break;

        case "Docente":
            frmUsuario.lblDato.setText("Departamento:");
            break;

        case "Administrativo":
            frmUsuario.lblDato.setText("Dependencia:");
            break;

        default:
            frmUsuario.lblDato.setText("Dato:");
            break;
    }
        
        
        
    }

 private void modificar() {

    int fila = frmUsuario.tableUsuarios.getSelectedRow();

    if (fila < 0) {
        return;
    }

    Usuario usuario = listaUsuarios.get(fila);

    usuario.setCc(frmUsuario.txtCC1.getText());
    usuario.setNombre(frmUsuario.txtNombre.getText());
    usuario.setDireccion(frmUsuario.txtDireccion.getText());
    usuario.setNumeroTel(frmUsuario.txtTelefono.getText());
    usuario.setCodigo(frmUsuario.txtCodigo.getText());

    actualizarTabla();
    limpiar();
}
  

        private void limpiar() {

    frmUsuario.txtCC1.setText("");
    frmUsuario.txtNombre.setText("");
    frmUsuario.txtDireccion.setText("");
    frmUsuario.txtTelefono.setText("");
    frmUsuario.txtCodigo.setText("");
    frmUsuario.txtDato.setText("");

    frmUsuario.cmbTipo.setSelectedIndex(0);
}

    

    private void actualizarTabla() {

    javax.swing.table.DefaultTableModel modelo =
            (javax.swing.table.DefaultTableModel)
            frmUsuario.tableUsuarios.getModel();

    modelo.setRowCount(0);

    for (Usuario u : listaUsuarios) {

        String tipo = u.getClass().getSimpleName();

        modelo.addRow(new Object[]{
            u.getCc(),
            u.getNombre(),
            u.getDireccion(),
            u.getNumeroTel(),
            u.getCodigo(),
            tipo,
            ""
        });
    }
}

    

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    
    
    
}

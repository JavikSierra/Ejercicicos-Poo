package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;
import view.*;

public class ControllerPrestamos {

    private JFPrestamos frmPrestamo;
    private ArrayList<Prestamo> listaPrestamos;
    private ControllerLibro controlLibros;
    private ControllerUsuario controlUsuario;

    public ControllerPrestamos(JFPrestamos frmPrestamo,
                               ControllerLibro controlLibros,
                               ControllerUsuario controlUsuario) {

        this.frmPrestamo = frmPrestamo;
        this.listaPrestamos = new ArrayList<>();
        this.controlLibros = controlLibros;
        this.controlUsuario = controlUsuario;

        initEvents();
    }

    private void initEvents() {

        frmPrestamo.btnDevolver.addActionListener(e -> devolverLibro());
        frmPrestamo.btnEliminar.addActionListener(e -> eliminar());
        frmPrestamo.btnLimpiar.addActionListener(e -> limpiar());
        frmPrestamo.btnRegistrar.addActionListener(e -> registrar());

        llenarComboBoxUsuarios();
        llenarComboLibros();

        frmPrestamo.cmbLibros.addActionListener(e -> llenarComboCopias());
    }

    
    private void registrar() {

        try {

            String id = frmPrestamo.txtID.getText().trim();

            if (id.isEmpty()
                    || frmPrestamo.txtFechaInicio.getText().trim().isEmpty()
                    || frmPrestamo.txtFechaFinal.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(frmPrestamo, "Complete todos los campos");
                return;
            }

            Usuario usuario = (Usuario) frmPrestamo.cmbUsuarios.getSelectedItem();
            Copia copia = (Copia) frmPrestamo.cmbCopia.getSelectedItem();

            if (usuario == null || copia == null) {
                JOptionPane.showMessageDialog(frmPrestamo, "Seleccione usuario y copia");
                return;
            }

            if (!copia.isDisponible()) {
                JOptionPane.showMessageDialog(frmPrestamo, "Copia no disponible");
                return;
            }

            LocalDate inicio = LocalDate.parse(frmPrestamo.txtFechaInicio.getText().trim());
            LocalDate fin = LocalDate.parse(frmPrestamo.txtFechaFinal.getText().trim());

            if (fin.isBefore(inicio)) {
                JOptionPane.showMessageDialog(frmPrestamo, "Fecha final inválida");
                return;
            }

            Prestamo p = new Prestamo(
                    id,
                    usuario,
                    copia,
                    EstadoPrestamo.PRESTADO,
                    inicio,
                    fin
            );

            copia.prestar();
            listaPrestamos.add(p);

            actualizarTabla();
            llenarComboCopias();
            limpiar();

            JOptionPane.showMessageDialog(frmPrestamo, "Préstamo registrado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frmPrestamo,
                    "Error en formato de fecha (yyyy-MM-dd)");
        }
    }


    private void devolverLibro() {

        int fila = frmPrestamo.tablePrestamos.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(frmPrestamo, "Seleccione un préstamo");
            return;
        }

        Prestamo p = listaPrestamos.get(fila);

        EstadoPrestamo estado = p.estadoActual();

        if (estado == EstadoPrestamo.MULTADO) {
            p.calcularMulta();

            JOptionPane.showMessageDialog(frmPrestamo,
                    "Multa generada: " + p.getMulta());
        }

        p.getCopia().liberar();
        p.marcarDevuelto();

        actualizarTabla();
        llenarComboCopias();
    }

  
    private void eliminar() {

        int fila = frmPrestamo.tablePrestamos.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(frmPrestamo, "Seleccione un préstamo");
            return;
        }

        Prestamo p = listaPrestamos.get(fila);

        if (p.estadoActual() != EstadoPrestamo.DEVUELTO) {
            p.getCopia().liberar();
        }

        listaPrestamos.remove(fila);

        actualizarTabla();
        llenarComboCopias();
    }

    
    private void limpiar() {

        frmPrestamo.txtID.setText("");
        frmPrestamo.txtFechaInicio.setText("");
        frmPrestamo.txtFechaFinal.setText("");

        if (frmPrestamo.cmbUsuarios.getItemCount() > 0) {
            frmPrestamo.cmbUsuarios.setSelectedIndex(0);
        }

        if (frmPrestamo.cmbLibros.getItemCount() > 0) {
            frmPrestamo.cmbLibros.setSelectedIndex(0);
        }
    }

 
    private void llenarComboBoxUsuarios() {

        frmPrestamo.cmbUsuarios.removeAllItems();

        for (Usuario u : controlUsuario.getListaUsuarios()) {
            frmPrestamo.cmbUsuarios.addItem(u);
        }
    }

    private void llenarComboLibros() {

        frmPrestamo.cmbLibros.removeAllItems();

        for (Libro l : controlLibros.getListaLibros()) {
            frmPrestamo.cmbLibros.addItem(l);
        }
    }

    private void llenarComboCopias() {

        frmPrestamo.cmbCopia.removeAllItems();

        Libro libroSeleccionado =
                (Libro) frmPrestamo.cmbLibros.getSelectedItem();

        if (libroSeleccionado == null) return;

        for (Copia copia : libroSeleccionado.getCopias()) {
            frmPrestamo.cmbCopia.addItem(copia);
        }
    }

    public void actualizarCombos() {
        llenarComboBoxUsuarios();
        llenarComboLibros();
        llenarComboCopias();
    }

    private void actualizarTabla() {

        javax.swing.table.DefaultTableModel modelo =
                (javax.swing.table.DefaultTableModel)
                        frmPrestamo.tablePrestamos.getModel();

        modelo.setRowCount(0);

        for (Prestamo p : listaPrestamos) {

            modelo.addRow(new Object[]{
                    p.getIdPrestamo(),
                    p.getUsuario().getNombre(),
                    p.getCopia().getIdCopia(),
                    p.getFechaPrestamo(),
                    p.getFechaDevolucion(),
                    p.estadoActual()
            });
        }
    }
}


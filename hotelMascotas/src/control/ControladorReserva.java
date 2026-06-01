package control;

import modelo.*;
import vista.JFReserva;

import javax.swing.*;
import java.util.ArrayList;

import static modelo.Servicio.*;

public class ControladorReserva{
    private JFReserva frmReserva;
    private ArrayList<Reserva> listaReserva;
    private ControladorRegistrarCuidador controlCuidador;
    private ControladorRegistrarDuenoMascota controlDuenoMascota;


    public ControladorReserva(JFReserva frmReserva, ControladorRegistrarCuidador controlCuidador, ControladorRegistrarDuenoMascota controlDuenoMascota) {
        this.frmReserva = frmReserva;
        this.controlCuidador = controlCuidador;
        this.controlDuenoMascota = controlDuenoMascota;
        this.listaReserva = new ArrayList<>();
        cargarServicios();
        initEvents();
    }

    private void cargarServicios() {
        this.frmReserva.cmbTipoServicio.removeAllItems();
        for (Servicio s : Servicio.values()) {
            this.frmReserva.cmbTipoServicio.addItem(s.name());
        }
    }

    private void initEvents() {
        this.frmReserva.btnRealizarReserva.addActionListener(e -> realizarReserva());
    }

    public void realizarReserva (){
        if (this.frmReserva.txtFechaIngreso.getText().isEmpty() || 
            this.frmReserva.txtDuracion.getText().isEmpty() || 
            this.frmReserva.txtNombreMascota.getText().isEmpty() || 
            this.frmReserva.txtCedulaDueno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos incompletos, operacion no realizada");
            return;
        }

        String fechaa = this.frmReserva.txtFechaIngreso.getText();
        String nomMascota = this.frmReserva.txtNombreMascota.getText();
        String cedulaD = this.frmReserva.txtCedulaDueno.getText();
        int duracion;
        Object selectedServicio = this.frmReserva.cmbTipoServicio.getSelectedItem();
        String servicio = selectedServicio != null ? selectedServicio.toString() : "";


        try {
            duracion = Integer.parseInt(this.frmReserva.txtDuracion.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La duración debe ser un número entero válido.");
            return;
        }

        Mascota mascota = buscarMascota(cedulaD, nomMascota);
        if (mascota == null){
            JOptionPane.showMessageDialog(null, "No se encontró el dueño con esa cédula o la mascota con ese nombre.");
        }

        else {
            Cuidador cuidadorAsignado = asignarCuidador(cedulaD, nomMascota, fechaa, duracion);
            if (cuidadorAsignado == null){
                JOptionPane.showMessageDialog(null, "No hay cuidadores disponibles para esa raza en la fecha y duración indicadas.");
            }
            else {
                Fecha fechaIngreso = crearFecha(fechaa);

                Reserva r = new Reserva (fechaIngreso, duracion, servicio, cuidadorAsignado, mascota);
                listaReserva.add(r);

                for (Fecha f: fechasOcupado(fechaa, duracion)){
                    cuidadorAsignado.aniadirFechaOcupado(f);
                }

                JOptionPane.showMessageDialog(null, "Reserva realizada con éxito. Cuidador asignado: " + cuidadorAsignado.getNombre());
                this.frmReserva.dispose();
            }
        }
    }

    public Cuidador asignarCuidador (String cedulaD, String nomMascota, String fecha, int duracion){

        Mascota m = buscarMascota (cedulaD, nomMascota);
        if (m == null) {
            return null;
        }
        String raza = m.getRaza();

        for (Cuidador c: controlCuidador.getListaCuidadores()){
            String [] aux = c.getRazas();
            for (int i = 0; i < aux.length; i++){
                if ((aux[i].equals(raza))&&(disponibleFecha (c, fecha, duracion))){
                    return c;
                }
            }
        }
        return null;
    }

    public Mascota buscarMascota (String cedulaD, String nomMascota){

        for (Cliente c: controlDuenoMascota.getListaClientes()){
            if (c.getCedula().equals(cedulaD)&&c.getMascota().getNombre().equals(nomMascota)){
                return c.getMascota();
            }
        }

        return null;
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }

    public Fecha crearFecha (String fechaa){

        String [] fechas = fechaa.split("/");
        int [] fecha = new int [fechas.length];

        for (int i = 0; i<3; i++){
            fecha [i] = Integer.parseInt(fechas [i]);
        }

        return new Fecha (fecha[0], fecha[1], fecha[2]);
    }

    public boolean disponibleFecha(Cuidador c, String fechaIngreso, int duracion){

        if (c.getDisponibilidad() == null){
            return true;
        }

        ArrayList<Fecha> nuevasFechas = fechasOcupado(fechaIngreso, duracion);

        for (Fecha f : c.getDisponibilidad()){

            for (Fecha fo : nuevasFechas){

                if (f.equals(fo)){
                    return false;
                }

            }
        }
        return true;
    }

    public ArrayList<Fecha> fechasOcupado(String fechaIngreso, int duracion) {
        ArrayList<Fecha> fechasOcu = new ArrayList<>();
        Fecha f = crearFecha(fechaIngreso);
        fechasOcu.add(f);

        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < duracion; i++) {
            Fecha ultimaFecha = fechasOcu.getLast();
            int diaActual = ultimaFecha.getDia();
            int mesActual = ultimaFecha.getMes();
            int anioActual = ultimaFecha.getAnio();

            int limiteDias = diasPorMes[mesActual];

            if (diaActual >= limiteDias) {
                if (mesActual == 12) {
                    fechasOcu.add(new Fecha(1, 1, anioActual + 1));
                }
                else {
                    fechasOcu.add(new Fecha(1, mesActual + 1, anioActual));
                }
            }
            else {
                fechasOcu.add(new Fecha(diaActual + 1, mesActual, anioActual));
            }
        }

        return fechasOcu;
    }


}

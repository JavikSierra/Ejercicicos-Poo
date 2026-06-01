package control;

import vista.*;
import modelo.Reserva;

public class ControladorPrincipal {
    private JFprincipal frmPrincipal;
    private JFRegistrarCuidador frmCuidador;
    private JFRegistrarDuenoMascota frmDuenoMascota;
    private JFReserva frmReserva;

    private ControladorRegistrarCuidador controlCuidador;
    private ControladorRegistrarDuenoMascota controlDuenoMascota;
    private ControladorReserva controlReserva;

    public ControladorPrincipal(JFprincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
        this.frmCuidador = new JFRegistrarCuidador();
        this.frmDuenoMascota = new JFRegistrarDuenoMascota();
        this.frmReserva= new JFReserva();

        this.controlCuidador = new ControladorRegistrarCuidador(frmCuidador);
        this.controlDuenoMascota = new ControladorRegistrarDuenoMascota(frmDuenoMascota);
        this.controlReserva = new ControladorReserva(frmReserva, controlCuidador, controlDuenoMascota);

        initEvents();
    }

    private void initEvents() {

        this.frmPrincipal.btnRegistrarDueno.addActionListener(
                e -> abrirDueno());

        this.frmPrincipal.btnRegistrarCuidador.addActionListener(
                e -> abrirCuidador());

        this.frmPrincipal.btnReservas.addActionListener(
                e -> abrirReserva());
        this.frmPrincipal.btnMostrarResrvas.addActionListener(e-> motrarReserva());

    }

    private void abrirDueno() {
        this.frmDuenoMascota.setLocationRelativeTo(null);
        this.frmDuenoMascota.setVisible(true);
    }

    private void abrirCuidador() {
        this.frmCuidador.setLocationRelativeTo(null);
        this.frmCuidador.setVisible(true);
    }

    private void abrirReserva() {
        this.frmReserva.setLocationRelativeTo(null);
        this.frmReserva.setVisible(true);
    }

    private void motrarReserva() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- RESERVAS REGISTRADAS ---\n\n");
        if (controlReserva.getListaReserva() == null || controlReserva.getListaReserva().isEmpty()) {
            sb.append("No hay reservas registradas.\n");
        } else {
            for (Reserva r : controlReserva.getListaReserva()) {
                sb.append("Mascota: ").append(r.getMascota().getNombre())
                  .append(" (Raza: ").append(r.getMascota().getRaza()).append(")\n");
                sb.append("Fecha de Ingreso: ").append(r.getFechaIngreso()).append("\n");
                sb.append("Duración: ").append(r.getDuracion()).append(" días\n");
                sb.append("Cuidador Asignado: ").append(r.getCuidador().getNombre()).append("\n");
                sb.append("Servicios / Necesidades Especiales: ").append(r.getServiciosAdicionales()).append("\n");
                sb.append("--------------------------------------------------\n\n");
            }
        }
        this.frmPrincipal.areaInformacion.setText(sb.toString());
    }

}

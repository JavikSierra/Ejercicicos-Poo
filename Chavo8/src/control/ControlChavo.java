package control;

import modelo.*;
import vista.JFSimulacionChavo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

public class ControlChavo implements ActionListener {

    private JFSimulacionChavo frm;
    private Chavo chavo;
    private Quico quico;
    private DonRamon donRamon;
    private DoniaFlorinda doniaFlorinda;
    private Barril barril;
    private Casa casaFlorinda, casaQuico, casaDonRamon;


    private Map<Object, Runnable> accionesBotones;
    private Map<Personaje, JLabel> etiquetasPersonajes;

    public ControlChavo(JFSimulacionChavo frm) {
        this.frm = frm;
        inicializarModelos();
        configurarMapas();
        configurarVista();
    }

    private void inicializarModelos() {
        chavo = new Chavo();
        quico = new Quico();
        donRamon = new DonRamon();
        doniaFlorinda = new DoniaFlorinda();
        barril = new Barril("Madera", "Barril", "El Barril del Chavo donde se esconde");
        casaFlorinda = new Casa(1, "Doña Florinda");
        casaQuico = new Casa(2, "Quico");
        casaDonRamon = new Casa(3, "Don Ramón");
    }

    private void configurarMapas() {

        etiquetasPersonajes = new HashMap<>();
        etiquetasPersonajes.put(chavo, frm.lblChavo);
        etiquetasPersonajes.put(quico, frm.lblQuico);
        etiquetasPersonajes.put(donRamon, frm.lblDonRamon);
        etiquetasPersonajes.put(doniaFlorinda, frm.lblDonaFlorinda);


        accionesBotones = new HashMap<>();
        accionesBotones.put(frm.btnBarril,
                () -> alternarRefugio(frm.lblChavo, barril.usar(), "El Chavo salió del barril."));
        accionesBotones.put(frm.btnCasa1,
                () -> alternarRefugio(frm.lblDonaFlorinda, casaFlorinda.entrar(), "Doña Florinda salió de su casa."));
        accionesBotones.put(frm.btnCasa2,
                () -> alternarRefugio(frm.lblQuico, casaQuico.entrar(), "Quico salió de su casa."));
        accionesBotones.put(frm.btnCasa3,
                () -> alternarRefugio(frm.lblDonRamon, casaDonRamon.entrar(), "Don Ramón salió de su casa."));
        accionesBotones.put(frm.btnInteractuar, this::accionInteractuar);
    }

    private void configurarVista() {

        Personaje[] personajes = { chavo, quico, donRamon, doniaFlorinda};
        for (Personaje p : personajes) {
            frm.cmbPersonaje1.addItem(p);
            frm.cmbPersonaje2.addItem(p);
        }


        for (Object boton : accionesBotones.keySet()) {
            if (boton instanceof javax.swing.JButton) {
                ((javax.swing.JButton) boton).addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Runnable accion = accionesBotones.get(e.getSource());
        if (accion != null) {
            accion.run();
        }
    }



    private void alternarRefugio(JLabel label, String mensajeEntrar, String mensajeSalir) {
        if (label.isVisible()) {
            label.setVisible(false);
            frm.AreaResults.setText(mensajeEntrar);
        } else {
            label.setVisible(true);
            frm.AreaResults.setText(mensajeSalir);
        }
    }

    private void accionInteractuar() {
        Personaje p1 = (Personaje) frm.cmbPersonaje1.getSelectedItem();
        Personaje p2 = (Personaje) frm.cmbPersonaje2.getSelectedItem();

        if (p1 == p2) {
            frm.AreaResults.setText("Un personaje no puede interactuar consigo mismo");
            return;
        }

        if (!asegurarVisibilidad(p1) || !asegurarVisibilidad(p2)) {
            return;
        }

        frm.AreaResults.setText(obtenerMensajeInteraccion(p1, p2));
    }

    private boolean asegurarVisibilidad(Personaje p) {
        JLabel label = etiquetasPersonajes.get(p);
        if (label != null && !label.isVisible()) {
            label.setVisible(true);
            frm.AreaResults.setText(p.getNombre() + " salió para poder interactuar");
            return false;
        }
        return true;
    }

    private String obtenerMensajeInteraccion(Personaje p1, Personaje p2) {
        String interaccionBase = p1.interactuar(p2) + "\n";

        if (esPareja(p1, p2, chavo, quico)) {
            return interaccionBase + chavo.pedirTortaJamon() + "\n Quico se burla y le dice que no";
        }
        if (esPareja(p1, p2, chavo, doniaFlorinda)) {
            return interaccionBase + "Doña Florinda regaña al Chavo por molestar a Quico";
        }
        if (esPareja(p1, p2, chavo, donRamon)) {
            return interaccionBase + chavo.pedirTortaJamon()
                    + "\nDon Ramón conversa con el Chavo y le regala una torta de jamón";
        }
        if (esPareja(p1, p2, quico, doniaFlorinda)) {
            return interaccionBase + quico.llorar() + "\nDoña Florinda consiente a Quico.";
        }
        if (esPareja(p1, p2, quico, donRamon)) {
            return interaccionBase + "Don Ramón pellizca a Quico\n" + quico.llorar();
        }
        if (esPareja(p1, p2, donRamon, doniaFlorinda)) {
            return interaccionBase + "Don Ramon pelea con Doña Florinda\n" + doniaFlorinda.darBofetada();
        }

        return interaccionBase;
    }

    private boolean esPareja(Personaje p1, Personaje p2, Personaje target1, Personaje target2) {
        return (p1 == target1 && p2 == target2) || (p1 == target2 && p2 == target1);
    }
}

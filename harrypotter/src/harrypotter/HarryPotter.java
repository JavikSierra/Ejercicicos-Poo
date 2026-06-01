package harrypotter;

import controller.ControllerMenuPrincipal;
import model.Escuela;
import view.JFMenuPrincipal;

public class HarryPotter {

    public static void main(String[] args) {

        Escuela escuela = new Escuela("Hogwarts");

        // Cargar datos iniciales
        escuela.cargarLocaciones();

        JFMenuPrincipal menu = new JFMenuPrincipal();

        new ControllerMenuPrincipal(menu, escuela);

        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
}

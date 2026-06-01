/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;
import view.*;
import controller.*;
/**
 *
 * @author User
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFPrincipal frmPrincipal = new JFPrincipal();

        ControllerPrincipal controller =
                new ControllerPrincipal(frmPrincipal);

        frmPrincipal.setLocationRelativeTo(null);
        frmPrincipal.setVisible(true);

    }
    
}

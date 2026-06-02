/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemanominaacademica;
import Model.*;
import view.*;
import Control.*;
/**
 *
 * @author Cristian Daniel
 */
public class SistemaNominaAcademica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        jfrPrincipal pantallaPrincipal=new jfrPrincipal();
        jftAniadirEmpleado pantallaAniadirEmpleado= new jftAniadirEmpleado();
        
        ControlPantallaPrincipal controlPantallaPrincipal=new ControlPantallaPrincipal(pantallaPrincipal, pantallaAniadirEmpleado);
        ControlPantallaAniadirEmpleado controlPantallaAniadirEmpleado=new ControlPantallaAniadirEmpleado(pantallaPrincipal, pantallaAniadirEmpleado, controlPantallaPrincipal);
        pantallaPrincipal.setVisible(true);
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.recomendacion;
import view.*;
import controller.*;
/**
 *
 * @author Jose Angarita
 */
public class SistemaRecomendacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       JFPrincipal principal = new JFPrincipal();
       ControllerPrincipal controlPrincipal= new ControllerPrincipal(principal);
       principal.setVisible(true);
        
    }
    
}

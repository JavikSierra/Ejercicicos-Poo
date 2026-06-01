
package colegio.alegria;
import view.*;
import controller.*;
public class ColegioAlegria {

    public static void main(String[] args) {
         
    JFPrincipal principal = new JFPrincipal();
    ControllerPrincipal control= new ControllerPrincipal(principal);
    principal.setVisible(true);




    }
    
}

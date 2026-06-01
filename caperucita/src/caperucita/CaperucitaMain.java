/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caperucita;
import Vista.*;
import Modelo.*;
import Controlador.*;
/**
 *
 * @author Cristian Daniel
 */
public class CaperucitaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        jfrCuento pantalla= new jfrCuento();
        ControlCuento controladorPantalla=new ControlCuento(pantalla);
        pantalla.setVisible(true);
    }
    
}

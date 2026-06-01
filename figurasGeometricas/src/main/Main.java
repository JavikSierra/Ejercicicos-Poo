/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import view.*;
import controller.*;
import Modelo.*;
        
/**
 *
 * @author Cristian Daniel
 */public class Main {
    public static void main(String[] args) {
        PantallaCalculadora pantalla = new PantallaCalculadora();
        ControlPantallaCalculadora control = new ControlPantallaCalculadora(pantalla);
        pantalla.setVisible(true);
    }
}


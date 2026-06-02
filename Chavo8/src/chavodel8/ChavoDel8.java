/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chavodel8;

import javax.swing.UIManager;

import control.ControlChavo;
import vista.JFSimulacionChavo;

/**
 *
 * @author Kleyber
 */
public class ChavoDel8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        JFSimulacionChavo frmSimulacion = new JFSimulacionChavo();
        ControlChavo control = new ControlChavo(frmSimulacion);
        frmSimulacion.setLocationRelativeTo(null);
        frmSimulacion.setVisible(true);
    }
}

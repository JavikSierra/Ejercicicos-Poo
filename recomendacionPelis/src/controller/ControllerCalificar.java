/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import controller.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import view.*;
import model.*;

/**
 *
 * @author Jose Angarita
 */
public class ControllerCalificar {
    
    private JFCalificar frmCalificar;
    private  ControllerPelicula controlPelicula;
    private ControllerUsuario controlUsuario;
    private ArrayList<Calificacion> listaCalificaciones;
    private ControllerRecomendar controlReco;
    
    public ControllerCalificar(JFCalificar frmCalificar, ControllerPelicula controlPelicula, ControllerUsuario controlUsuario,ControllerRecomendar controlReco) {
        this.frmCalificar = frmCalificar;
        this.controlPelicula = controlPelicula;
        this.controlUsuario = controlUsuario;
        this.listaCalificaciones= new ArrayList();
        this.controlReco=controlReco;
         llenarComboUsuarios();
         llenarComboPeliculas();
        initEvents();
    }
    
    public void initEvents(){
        this.frmCalificar.btnEnviar.addActionListener(e->enviar());
    }

    private void enviar() {
        
        Usuario u =
        (Usuario) this.frmCalificar.cmbUsuario
                .getSelectedItem();

        Pelicula p =
        (Pelicula) this.frmCalificar.cmbPeliculas
                .getSelectedItem();

        String calificacion =
                this.frmCalificar.txtCalificacion.getText();
                        

        if(u == null || p == null
                || calificacion.isEmpty()) {

            return;
        }

        Calificacion c= new Calificacion(p, calificacion, u);
        listaCalificaciones.add(c);
        if(Double.parseDouble(calificacion)>10.0){
            JOptionPane.showMessageDialog(null, "Calificaciones mayores que 10  no son posibles");
            return;
        }
        p.promediarCalificacion(Double.parseDouble(calificacion));
         controlReco.agregarPeliculas();     

        this.frmCalificar.txtCalificacion
                .setText("");
        
        
        
    }
    
     public void llenarComboUsuarios() {

        ArrayList<Usuario> listaUsuarios =
                this.controlUsuario
                        .getListaUsuarios();

        DefaultComboBoxModel modelo =
                new DefaultComboBoxModel();

        for(Usuario u : listaUsuarios) {

            modelo.addElement(u);

        }

        this.frmCalificar.cmbUsuario
                .setModel(modelo);

    }
    
        public void llenarComboPeliculas() {

        ArrayList<Pelicula> listaPeliculas =
                this.controlPelicula
                        .getListaPeliculas();

        DefaultComboBoxModel modelo =
                new DefaultComboBoxModel();

        for(Pelicula p : listaPeliculas) {

            modelo.addElement(p);

        }

        this.frmCalificar.cmbPeliculas
                .setModel(modelo);

    }
    
    
}

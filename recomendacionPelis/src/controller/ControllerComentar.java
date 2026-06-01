
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.*;
import view.*;

/**
 *
 * @author Jose Angarita
 */
public class ControllerComentar {
    
    private JFComentar frmComentar;
    private ControllerUsuario controlUsuario;
    private ControllerPelicula controlPelicula;
    private ControllerRecomendar controlReco;
    
    
    public ControllerComentar(
            JFComentar frmComentar,
            ControllerUsuario controlUsuario,
            ControllerPelicula controlPelicula,ControllerRecomendar controlReco  ){
        
        this.frmComentar = frmComentar;
        this.controlUsuario = controlUsuario;
        this.controlPelicula = controlPelicula;
        this.controlReco=controlReco;

        llenarComboUsuarios();
        llenarComboPeliculas();

        initEvents();
    }

    private void initEvents() {

        this.frmComentar.btnEnviar
                .addActionListener(e -> comentar());

    }

    private void comentar() {

        Usuario u =
        (Usuario) this.frmComentar.cmbUsuario
                .getSelectedItem();

        Pelicula p =
        (Pelicula) this.frmComentar.cmbPeliculas
                .getSelectedItem();

        String comentario =
                this.frmComentar.txtComentario
                        .getText();

        if(u == null || p == null
                || comentario.isEmpty()) {
            
            return;
        }

        Comentario nuevoComentario =   new Comentario(comentario,u, p);
               
           p.getListaDeComentarios().add(nuevoComentario);

        System.out.println( p.getListaDeComentarios().size());  

                          
        
       
        controlReco.agregarPeliculas();

        this.frmComentar.txtComentario
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

        this.frmComentar.cmbUsuario
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

        this.frmComentar.cmbPeliculas
                .setModel(modelo);

    }

}


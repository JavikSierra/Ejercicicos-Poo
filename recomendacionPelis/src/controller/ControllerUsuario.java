/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import view.*;
import model.*;

/**
 *
 * @author Jose Angarita
 */
public class ControllerUsuario {
    
    private JFUsuario frmUsuario;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Pelicula> listaPeliculasVistas;
    private ArrayList<Genero> listaGenerosPreferidos;
    private ControllerPelicula controlPeli;
    private JFPelicula frmPelicula;
    

 public ControllerUsuario(
        JFUsuario frmUsuario,
        ControllerPelicula controlPeli) {

    this.frmUsuario = frmUsuario;
    this.controlPeli = controlPeli;

    this.listaUsuarios = new ArrayList<>();
    this.listaGenerosPreferidos = new ArrayList<>();
    this.listaPeliculasVistas = new ArrayList<>();

    initEvents();
}

    private void initEvents() {

        this.frmUsuario.btnEnviar.addActionListener(e->registrar());
        this.frmUsuario.btnMostrar.addActionListener(e->mostrar());
        this.frmUsuario.btnAñadir.addActionListener(e->añadirPelicula());
        llenarComboPeliculas();
        this.frmUsuario.cmbGeneros.setModel( new DefaultComboBoxModel(Genero.values()));
        this.frmUsuario.chkPelicula.addActionListener(e->guardarPeliculas());
        this.frmUsuario.chkPreferencias.addActionListener(e->guardarGeneros());
    }

    private void registrar() {
        
   String id = this.frmUsuario.txtId.getText();
    String nombre = this.frmUsuario.txtNombre.getText();

    if(id.isEmpty() || nombre.isEmpty()) {

        this.frmUsuario.areaInformacion.setText(
                "POR FAVOR COMPLETE TODOS LOS ESPACIOS"
        );
        return;
    }

    for(Usuario u:listaUsuarios){
        if(u.getId().equals(id)){
              this.frmUsuario.areaInformacion.setText(
                "Usuario duplicado"
        );
        return;
        }
    }
    
    Usuario user = new Usuario(
            nombre,
            id,
            new ArrayList<>(listaGenerosPreferidos),
            new ArrayList<>(listaPeliculasVistas)
    );

    listaUsuarios.add(user);
   
    
    frmUsuario.areaInformacion.append(
            "-----------Usuario añadido------------\n"
            + "Nombre: " + user.getNombre() + "\n"
            + "ID: " + user.getId() + "\n"
            + "GENEROS QUE LE GUSTAN:\n"
            + user.getListaPreferencias().toString() + "\n"
            + "PELICULAS QUE HA VISUALIZADO:\n"
            + user.getHistorialVisualizacion().toString() + "\n"
    );

    limpiar();

    listaPeliculasVistas.clear();
    listaGenerosPreferidos.clear();
     

    }

    private void guardarPeliculas(){
    
     if(this.frmUsuario.chkPelicula.isSelected()){
         Pelicula p=  (Pelicula) this.frmUsuario.cmbPeliculas.getSelectedItem() ;
            if(p!=null){
                listaPeliculasVistas.add(p);
                 frmUsuario.areaInformacion.append(
                   "\n"+ "Pelicula agregada: "
                    +p.getNombre()+ "\n"
                     );
                 frmUsuario.chkPelicula.setSelected(false);
                
            }
        }
    
    
   
}
    
    
    private void guardarGeneros(){
    
     if(this.frmUsuario.chkPreferencias.isSelected()){
         Genero g=  (Genero) this.frmUsuario.cmbGeneros.getSelectedItem() ;
            if(g!=null){
                listaGenerosPreferidos.add(g);
                 frmUsuario.areaInformacion.append(
                    "Genero agregado: "
                    +g.name()+ "\n"
                     );
                 frmUsuario.chkPreferencias.setSelected(false);
                
            }
        }
    
    
    
}
    
    
    private void limpiar(){

    this.frmUsuario.txtId.setText("");
    this.frmUsuario.txtNombre.setText("");
    this.frmUsuario.txtMostrar.setText("");

    this.frmUsuario.cmbPeliculas.setSelectedIndex(0);
    this.frmUsuario.cmbGeneros.setSelectedIndex(0);

    this.frmUsuario.chkPelicula.setSelected(false);
    this.frmUsuario.chkPreferencias.setSelected(false);

 

    this.frmUsuario.txtId.requestFocus();

}
    
    
    
    
    
    
    private void mostrar() {

            String nombreBuscar =
            this.frmUsuario.txtMostrar.getText();

    if(nombreBuscar.isEmpty()){

        this.frmUsuario.areaInformacion.setText(
                "INGRESE UN NOMBRE"
        );

        return;
    }

    for(Usuario u : listaUsuarios){

        if(u.getNombre().equalsIgnoreCase(nombreBuscar)){

            this.frmUsuario.areaInformacion.setText(

                    "ID: " + u.getId() + "\n\n"

                    + "NOMBRE: "
                    + u.getNombre() + "\n\n"

                    + "GENEROS PREFERIDOS:\n"
                    + u.getListaPreferencias().toString()
                    + "\n\n"

                    + "PELICULAS VISTAS:\n"
                    + u.getHistorialVisualizacion().toString()

            );

            return;
        }

    }

    this.frmUsuario.areaInformacion.setText(
            "USUARIO NO ENCONTRADO"
    );

        
        
        
    }

    private void añadirPelicula() {

       frmPelicula.setVisible(true);



    }

    private void llenarComboPeliculas() {

        ArrayList<Pelicula> listaPeliculas = controlPeli.getListaPeliculas();
        DefaultComboBoxModel modelo= new DefaultComboBoxModel();

        for(Pelicula p:listaPeliculas){
            modelo.addElement(p);
        }

        this.frmUsuario.cmbPeliculas.setModel(modelo);


    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
   
    
}
// || listaGenerosPreferidos.isEmpty() 
//            || listaPeliculasVistas.isEmpty()
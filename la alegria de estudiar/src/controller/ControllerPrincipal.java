
package controller;
import view.*;

public class ControllerPrincipal {
    
    private JFPrincipal frmPrincipal;
    private JFRegistrarCandidato frmRegistrar;
    private JFVotar frmVotar;
    private ControllerRegistrarCandidato controllerRegistrar;
    private ControllerVotar controllerVotar;

    public ControllerPrincipal(JFPrincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
        this.frmRegistrar = new JFRegistrarCandidato();
        this.frmVotar = new JFVotar();
        this.controllerRegistrar= new ControllerRegistrarCandidato(frmRegistrar);
        this.controllerVotar= new ControllerVotar(frmVotar,controllerRegistrar);
          
        initEvents();
    }

    private void initEvents() {

        this.frmPrincipal.btnRegistrar.addActionListener(e->abrirRegistrar());
        this.frmPrincipal.btnVotar.addActionListener(e->abrirVotar());
    }

    private void abrirRegistrar() {
        
        frmRegistrar.setVisible(true);
    }

    private void abrirVotar() {
        
        frmVotar.setVisible(true);
        
    }
    
    
    
    
    
    
}

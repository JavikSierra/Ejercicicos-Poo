/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import view.*;
import model.*;
/**
 *
 * @author Jose Angarita
 */
public class ControllerVotar {
    
    private JFVotar frmVotar;
   private ArrayList<Voto> listaVotos;
   private JFRegistrarCandidato frmCandidato;
   private ControllerRegistrarCandidato controlCandidato;
  private ArrayList<Voto> listaVotosBlancos;
   private ArrayList<Voto> listaVotosNulos;
   
    public ControllerVotar(JFVotar frmVotar,  ControllerRegistrarCandidato controlCandidato) {

            this.frmVotar = frmVotar;
              this.listaVotos = new ArrayList();
              this.listaVotosBlancos=new ArrayList();
              this.listaVotosNulos= new ArrayList();
             this.controlCandidato = controlCandidato;

              initEvents();
}

    private void initEvents() {
        this.frmVotar.btnEnviarVotoBN.setVisible(false);
        this.frmVotar.panelCandidatos.setVisible(false);
        this.frmVotar.cmbEleccion.addActionListener(e->habilitarPanel());
        this.frmVotar.btnEnviar.addActionListener(e->enviarVoto());
        this.frmVotar.cmbCandidatos.addActionListener(e->mostrarImagen());
        this.frmVotar.chkBlanco.addActionListener(e->habilitarBotonEnviarVotoBlancoNulo());
          this.frmVotar.chkNulo.addActionListener(e->habilitarBotonEnviarVotoBlancoNulo());
          this.frmVotar.btnEnviarVotoBN.addActionListener(e->enviarVoto());
          this.frmVotar.btnResultados.addActionListener(e->mostrarResultados());
    }

    private void habilitarPanel() {
        
        String decision= (String) this.frmVotar.cmbEleccion.getSelectedItem();
        
         if(decision == null){
        this.frmVotar.panelCandidatos.setVisible(false);
        return;
    }
        if(decision.equals("Personero")){
            
            this.frmVotar.panelCandidatos.setVisible(true);
            ( (TitledBorder)  this.frmVotar.panelCandidatos.getBorder()).setTitle("Personero");
              this.frmVotar.panelCandidatos.repaint();
               
              ArrayList<Candidato> listaCandidatos= controlCandidato.getListaCandidatos();
              ArrayList<Personero> listaPersoneros=new ArrayList();
              for(Candidato c: listaCandidatos){
                  if(c instanceof Personero){
                      listaPersoneros.add( (Personero) c); 
                 }
              }
              DefaultComboBoxModel modelo=  new DefaultComboBoxModel();
              
              for(Personero p: listaPersoneros){
                  modelo.addElement(p);
              }
              
              this.frmVotar.cmbCandidatos.setModel(modelo);
              
              
        }else if(decision.equals("Representante de grado")){
             this.frmVotar.panelCandidatos.setVisible(true);
            ( (TitledBorder)  this.frmVotar.panelCandidatos.getBorder()).setTitle("Representante");
              this.frmVotar.panelCandidatos.repaint();
              
              ArrayList<Candidato> listaCandidatos= controlCandidato.getListaCandidatos();
              ArrayList<RepresentanteGrado> listaRepresentantes=new ArrayList();
              for(Candidato c: listaCandidatos){
                  if(c instanceof RepresentanteGrado){
                      listaRepresentantes.add( (RepresentanteGrado) c); 
                 }
              }
              DefaultComboBoxModel modelo=  new DefaultComboBoxModel();
              
              for(RepresentanteGrado p: listaRepresentantes){
                  modelo.addElement(p);
              }
              
              this.frmVotar.cmbCandidatos.setModel(modelo);
        }else {
              this.frmVotar.panelCandidatos.setVisible(false);
        }
    
        
        

    }

    private void enviarVoto() {
        
         String decision = (String) this.frmVotar.cmbEleccion.getSelectedItem();

    if (decision == null || decision.equals("")) {
        JOptionPane.showMessageDialog(null,
                "SELECCIONE UNA ELECCIÓN");
        return;
    }

    if(decision.equals("Personero")){

        Candidato candidato =
                (Candidato) this.frmVotar.cmbCandidatos.getSelectedItem();

        if(candidato != null){

            Voto v = new Voto(false, candidato, false, decision);

            listaVotos.add(v);

            candidato.aumentarVotos();

            JOptionPane.showMessageDialog(null,
                    "HA VOTADO EXITOSAMENTE");

        }else{

            JOptionPane.showMessageDialog(null,
                    "POR FAVOR SELECCIONE EL CANDIDATO A VOTAR");
        }

    }else if(decision.equals("Representante de grado")){

        Candidato candidato =
                (Candidato) this.frmVotar.cmbCandidatos.getSelectedItem();

        if(candidato != null){

            Voto v = new Voto(false, candidato, false, decision);

            listaVotos.add(v);

            candidato.aumentarVotos();

            JOptionPane.showMessageDialog(null,
                    "HA VOTADO EXITOSAMENTE");

        }else{

            JOptionPane.showMessageDialog(null,
                    "POR FAVOR SELECCIONE EL CANDIDATO A VOTAR");
        }
    }

    Boolean decisionBlanca =
            this.frmVotar.chkBlanco.isSelected();

    Boolean decisionNula =
            this.frmVotar.chkNulo.isSelected();

    if(decisionBlanca == true){

        Voto v = new Voto(true, null, false, "");

        listaVotosBlancos.add(v);

        JOptionPane.showMessageDialog(null,
                "HA VOTADO EXITOSAMENTE");

    }else if(decisionNula == true){

        Voto v = new Voto(false, null, true, "");

        listaVotosBlancos.add(v);

        JOptionPane.showMessageDialog(null,
                "HA VOTADO EXITOSAMENTE");
    }
              
    }

    private void mostrarImagen() {

        Candidato candidato = (Candidato) this.frmVotar.cmbCandidatos.getSelectedItem();
        
        this.frmVotar.lblImagen.setIcon(new ImageIcon(candidato.getRutaImagen()));
        
        
    }

    private void habilitarBotonEnviarVotoBlancoNulo() {
        
        Boolean decision = this.frmVotar.chkBlanco.isSelected();
        Boolean decision2 = this.frmVotar.chkNulo.isSelected();
        
        if(decision==true || decision2==true){
            this.frmVotar.btnEnviarVotoBN.setVisible(true);
        } else if(decision ==false || decision2==false){
            this.frmVotar.btnEnviarVotoBN.setVisible(false);
        }
       
    }

    private void mostrarResultados() {

       int totalVotosRepresentante=0;
       int totalVotos=0;
       int totalVotosPersonero=0;
       Personero pGanador=null;
       RepresentanteGrado rGanador=null;
       Personero pPerdedor=null;
       RepresentanteGrado rPerdedor=null;
       int totalVotosBlancos=listaVotosBlancos.size();
       int totalVotosNulos= listaVotosNulos.size();
       
       if(listaVotos. isEmpty()){
           
            JOptionPane.showMessageDialog(null,
                    "NADIE HA VOTADO AUN ");
       }
       for(Voto v: listaVotos){
           
           if(v.getCandidato() instanceof  RepresentanteGrado){
                totalVotosRepresentante+=1;
                totalVotos+=1;
            }else if(v.getCandidato() instanceof  Personero){
                 totalVotosPersonero+=1;
                totalVotos+=1;
            }
          
            
       }

         totalVotos+=listaVotosBlancos.size();
            totalVotos+=listaVotosNulos.size();
            
          int votosAnteriorR=0;
         for(Voto v:listaVotos){
             if(v.getCandidato() instanceof  RepresentanteGrado){
                 if(v.getCandidato().getCantidadVotos()>votosAnteriorR){
                     rGanador= (RepresentanteGrado) v.getCandidato();
                      votosAnteriorR=v.getCandidato().getCantidadVotos();
                 }
                
             }
               
         }
        
            
          int votosAnteriorP=0;
         for(Voto v:listaVotos){
             if(v.getCandidato() instanceof  Personero){
                 if(v.getCandidato().getCantidadVotos()>votosAnteriorP){
                     pGanador= (Personero) v.getCandidato();
                      votosAnteriorP=v.getCandidato().getCantidadVotos();
                 }
                
             }
               
         }

         
         int votosMenorR = Integer.MAX_VALUE;

        for(Voto v : listaVotos){
            
            if(v.getCandidato() instanceof RepresentanteGrado){

             if(v.getCandidato().getCantidadVotos() < votosMenorR){

            votosMenorR =
                    v.getCandidato().getCantidadVotos();

            rPerdedor =
                    (RepresentanteGrado) v.getCandidato();
                 }
            }
        }
         
         int votosMenorP = Integer.MAX_VALUE;

        for(Voto v : listaVotos){

            if(v.getCandidato() instanceof Personero){

             if(v.getCandidato().getCantidadVotos() < votosMenorP){

            votosMenorP =
                    v.getCandidato().getCantidadVotos();

            pPerdedor =
                    (Personero) v.getCandidato();
              }
          }
        }
         
         this.frmVotar.AreaGanador.setText(
          
                 
        "\n-----------------------RESUMEN DE VOTOS----------------------------"+         
          "\nTOTAL DE VOTOS: "+ totalVotos+        
          "\nTOTAL DE VOTOS BLANCOS: "+ totalVotosBlancos+
           "\nTOTAL DE VOTOS NULOS: "+ totalVotosNulos+
         "\n-----------------------PERSONERO----------------------------"+
          "\nTOTAL DE VOTOS POR PERSONEROS: "+ totalVotosPersonero+
         "\nPERSONERO GANADOR: "+ pGanador+
         "\nPERSONERO CON MENOR VOTOS: "+ pPerdedor+
         "\n-----------------------REPRESENTANTE---------------------------- "+
         "\nTOTAL DE VOTOS POR REPRESENTANTES: "+ totalVotosRepresentante+
         "\nREPRESENTANTE GANADOR: "+rGanador+
          "\nREPRESENTANTE CON MENOR VOTOS: "+rPerdedor
       
         
         
         );
         if(pGanador!=null || rGanador!=null){
              String rutaP= pGanador.getRutaImagen();
         this.frmVotar.lblPersoneroGanador.setIcon(new ImageIcon(rutaP));
          String rutaR= rGanador.getRutaImagen();
         this.frmVotar.lblIRepresentanteGanador.setIcon(new ImageIcon(rutaR));
         }
        
         
    }
    
   
    
    
    
    
    
    
    
   
}


package controller;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.border.TitledBorder;
import view.*;
import model.*;

public class ControllerRegistrarCandidato {
    
    private JFRegistrarCandidato frmCandidato;
    private ArrayList<Candidato> listaCandidatos;
   private JFRegistrarMascota frmMascota;
   private JFRegistrarFormula frmFormula;
   private ControllerMascota controlMascota;
   private ControllerFormula controlFormula;
    private String ruta;
   
    public ControllerRegistrarCandidato(JFRegistrarCandidato registrarCandidato) {
     
        this.frmMascota= new JFRegistrarMascota();
         this.frmFormula= new JFRegistrarFormula();
        this.frmCandidato = registrarCandidato;
        this.listaCandidatos = new ArrayList();
           this.controlFormula=new ControllerFormula(frmFormula,this);
         this.controlMascota=new ControllerMascota(frmMascota,this);
        initEvents();
    }

    
    public void initEvents(){
        
        this.frmCandidato.btnRegistrar.addActionListener(e->registrar());
        this.frmCandidato.btnMostrar.addActionListener(e->mostrar());
        this.frmCandidato.cmbTipo.addActionListener(e->habilitarPanel());
        this.frmCandidato.panelPersonero.setVisible(false);
        this.frmCandidato.btnAñadirImagen.addActionListener(e->registrarImagen());
        this.frmCandidato.btnAgregarDato.addActionListener(e->añadirDatoCmb());
    }

    private void registrar() {
       
      String nombre= this.frmCandidato.txtNombre.getText();
      String apellido = this.frmCandidato.txtApellido.getText();
      String grado= this.frmCandidato.txtGrado.getText();
      String lema= this.frmCandidato.txtLema.getText();
      String numeroTarjeton = this.frmCandidato.txtTarjeton.getText();
      
      
       
     
    
      String decision= (String) this.frmCandidato.cmbTipo.getSelectedItem();
                    
                if(decision.equals("Personero")){
                    
                            Mascota mascota= (Mascota) this.frmCandidato.cmbDatoExtra.getSelectedItem();
                            
                            
                            
                         if(nombre.isEmpty() || apellido.isEmpty() || grado.isEmpty() || lema.isEmpty() || numeroTarjeton.isEmpty() || mascota==null || ruta.isEmpty()){
                              this.frmCandidato.areaResults.setText("COMPLETE LOS ESPACIOS");
                               return;
                            }
                        
                           ArrayList<Mascota> listaMascotas= controlMascota.getListaMascotas();
                           System.out.println(mascota.toString());
                         
                          
                         
                                   
                       Personero p= new Personero( nombre, apellido, grado, lema, numeroTarjeton,mascota, ruta);
                       System.out.println(
                               p.getNombre()+"\n"+p.getApellido()+"\n"+p.getGrado()+"\n"+p.getLema()+"\n"+p.getNumeroTarjeton()+"\n"+p.getMascota().toString()+"\n"+p.getRutaImagen());
                       
                               listaCandidatos.add(p);
                       
                       
                       limpiar();
               }else if(decision.equals("Representante de grado")){
            
                    Estudiante formula= (Estudiante) this.frmCandidato.cmbDatoExtra.getSelectedItem();
                           
                           
                            
                         if(nombre.isEmpty() || apellido.isEmpty() || grado.isEmpty() || lema.isEmpty() || numeroTarjeton.isEmpty() || formula==null || ruta.isEmpty()){
                              this.frmCandidato.areaResults.setText("COMPLETE LOS ESPACIOS");
                               return;
                            }
                         
                         ArrayList<Estudiante> listaEstudiante= controlFormula.getListaFormulas();
                           System.out.println(formula.toString());
                           
                       RepresentanteGrado r = new RepresentanteGrado( nombre, apellido, grado, lema, numeroTarjeton,formula, ruta);
                       System.out.println(
                              r.getNombre()+"\n"+r.getApellido()+"\n"+r.getGrado()+"\n"+r.getLema()+"\n"+r.getNumeroTarjeton()+"\n"+r.getFormula().toString()+"\n"+r.getRutaImagen());
                             listaCandidatos.add(r);
                       limpiar();
                   
                   
                   
                  }
                      
      
      
    
    }

    private void mostrar() {
      
        String nombre= this.frmCandidato.txtNombre.getText();
        
        if(nombre.isEmpty()){
            this.frmCandidato.areaResults.setText("El campo de nombre es obligatorio");
            return;
        }
        
        for(Candidato c:listaCandidatos){
            
            if(nombre.equals(c.getNombre())){
                
                if(c instanceof Personero){
                    Personero p= (Personero) c;
                this.frmCandidato.areaResults.setText("nombre: "+ p.getNombre()
                        +"\napellido: "+p.getApellido()
                        +"\ngrado: "+p.getGrado()
                        +"\nlema: "+p.getLema()
                        +"\ntarjeton: "+p.getNumeroTarjeton()
                        +"\nmascota: "+p.getMascota()
                         
                          );
                this.frmCandidato.lblImagen.setIcon(new ImageIcon(ruta));
                           
                           System.out.println("nombre: "+ p.getNombre()
                        +"\napellido: "+p.getApellido()
                        +"\ngrado: "+p.getGrado()
                        +"\nlema: "+p.getLema()
                        +"\ntarjeton: "+p.getNumeroTarjeton()
                        +"\nmascota: "+p.getMascota());
                           return;
                     }else if(c instanceof RepresentanteGrado){
                           RepresentanteGrado r= (RepresentanteGrado) c;
                         this.frmCandidato.areaResults.setText("nombre: "+ r.getNombre()
                        +"\napellido: "+r.getApellido()
                        +"\ngrado: "+r.getGrado()
                        +"\nlema: "+r.getLema()
                        +"\ntarjeton: "+r.getNumeroTarjeton()
                        +"\nformula "+r.getFormula()
                
                          );
                         System.out.println("nombre: "+ r.getNombre()
                        +"\napellido: "+r.getApellido()
                        +"\ngrado: "+r.getGrado()
                        +"\nlema: "+r.getLema()
                        +"\ntarjeton: "+r.getNumeroTarjeton()
                        +"\nformula "+r.getFormula());
                         return;
                         
                     }
            }
        }
        
    }
            
    
    public void habilitarPanel(){
        
        if(this.frmCandidato.cmbTipo.getSelectedItem()!=null){
             String decision= (String) this.frmCandidato.cmbTipo.getSelectedItem();
             
             ArrayList<Mascota> listaMascotas= controlMascota.getListaMascotas();
              ArrayList<Estudiante> listaEstudiantes=controlFormula.getListaFormulas();
             
             System.out.println(decision);
             if(decision.equals("Personero")){
                      
                        this.frmCandidato.panelPersonero.setVisible(true);
                         this.frmCandidato.lblDato.setText("Mascota");
                        
                         
                          DefaultComboBoxModel<Object> modelo = new DefaultComboBoxModel();
                         
                          for(Mascota m:listaMascotas){
                              modelo.addElement(m);
                          }
                         
                         this.frmCandidato.cmbDatoExtra.setModel(modelo);
                         
                }   else if(decision.equals("Representante de grado")){
                              this.frmCandidato.panelPersonero.setVisible(true);
                                this.frmCandidato.lblDato.setText("Formula");
                            ( (TitledBorder)  this.frmCandidato.panelPersonero.getBorder()).setTitle("Representante");
                             this.frmCandidato.panelPersonero.repaint();
                             
                            
                         
                          DefaultComboBoxModel<Object> modelo = new DefaultComboBoxModel();
                         
                          for(Estudiante e:listaEstudiantes){
                              modelo.addElement(e);
                          }
                         
                         this.frmCandidato.cmbDatoExtra.setModel(modelo);
                             
                             
                             
                  }     
        }        
        
       
        
        
        
    }

    private void registrarImagen() {
        
      JFileChooser selector = new JFileChooser();

        int opcion = selector.showOpenDialog(frmCandidato);
        
    
                
    if(opcion == JFileChooser.APPROVE_OPTION){

    
         ruta=   selector.getSelectedFile()
                    .getAbsolutePath();
   
    
        }
    
        
    }

    public ArrayList<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

   private void limpiar(){
       
         this.frmCandidato.txtNombre.setText("");
       this.frmCandidato.txtApellido.setText("");
     this.frmCandidato.txtGrado.setText("");
       this.frmCandidato.txtLema.setText("");
       this.frmCandidato.txtTarjeton.setText("");
       this.frmCandidato.cmbDatoExtra.setSelectedIndex(0);
       
       
       
       
   }

    private void añadirDatoCmb() {

          String decision= (String) this.frmCandidato.cmbTipo.getSelectedItem();
        if(decision.equals("Personero")){
             frmMascota.setVisible(true);
           
        }else{
            frmFormula.setVisible(true);
            
         
        }
        
    }
    
    
    
    
    
    
    
}

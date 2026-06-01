/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cristian Daniel
 */
public class ControlCuento {
    private ArrayList<String>PartesDelCuento;
    private jfrCuento pantalla ;
    private int indice=0;
   private Lobo lobo1;
   private Caperucita caperucita1;
   private Abuela abuela1;
    private Leñador cazador1;
    private Bosque entorno1;
    
    
    public ControlCuento(jfrCuento pantalla) {
       this.pantalla = pantalla;
         this.PartesDelCuento = new ArrayList();
        initedEvent();
        pantalla.btmSiguiente.setVisible(false);
        pantalla.btmAbuela.setVisible(false);
        pantalla.btmCaperuza.setVisible(false);
        pantalla.btmCazador.setVisible(false);
        pantalla.btmLobo.setVisible(false);
        pantalla.btmEntorno.setVisible(false);
        pantalla.btmHablar.setVisible(false);
        pantalla.btmMoverse.setVisible(false);
        
        this.lobo1=new Lobo();
        this.caperucita1=new Caperucita();
        this.abuela1=new Abuela();
        this.cazador1=new Leñador();
        this.entorno1=new Bosque();
        
        
       
    }
     
    public void initedEvent(){
    pantalla.btmIniciar.addActionListener((e) -> iniciar());
    pantalla.btmSiguiente.addActionListener((e) -> siguiente());
    pantalla.btmCaperuza.addActionListener((e) -> caperuza());
    pantalla.btmAbuela.addActionListener((e) -> abuela());
    pantalla.btmCazador.addActionListener((e) -> cazador());
    pantalla.btmEntorno.addActionListener((e) -> Entorno());
    pantalla.btmLobo.addActionListener((e) -> lobo());
    
    }
    public void iniciar(){
        pantalla.btmSiguiente.setVisible(true);
        PartesDelCuento.add("1️⃣ Inicio del cuento " 
                + "\nCaperucita Roja vivía en una pequeña aldea junto a su madre."
                + "Un día, su madre le pidió llevar una cesta"
                + " con comida a su abuela enferma que vivía al "
                + "otro lado del bosque.");
        PartesDelCuento.add("2️⃣ Camino hacia el bosque "
                + "Antes de salir, su madre le advirtió que no hablara con "
                + "extraños y que siguiera el camino. Caperucita, alegre y "
                + "curiosa, se adentró entre los árboles cantando.");
        PartesDelCuento.add("3️⃣ Encuentro con el lobo  \n" 
                +"En medio del bosque, apareció un lobo astuto que le preguntó adónde iba."
                + " Ella, sin sospechar nada, le contó sobre su abuela. El lobo ideó un plan "
                + "y se adelantó por otro camino.");
        PartesDelCuento.add("4️⃣ El engaño del lobo  \n"
                +"El lobo llegó primero a la casa de la abuela, la encerró y se disfrazó con su ropa."
                + " Cuando Caperucita llegó, notó algo extraño en su “abuela”.");
        PartesDelCuento.add("5️⃣ El descubrimiento  \n" 
                + "Caperucita se acercó y dijo: “¡Abuelita, qué ojos tan grandes tienes!”. "
                + "El lobo respondió: “Son para verte mejor”. Así siguió hasta que el "
                + "lobo saltó de la cama para atraparla.");
        PartesDelCuento.add("6️⃣ El rescate  "
                +"Un cazador que pasaba cerca escuchó los gritos, entró a la casa y "
                + "logró salvar a Caperucita y a su abuela. El lobo huyó"
                + " y nunca volvió a molestar.");
        PartesDelCuento.add("7️⃣ Final y moraleja  \n"
                +"Caperucita aprendió a obedecer a su madre y a no hablar con desconocidos."
                + " Desde entonces, siempre siguió el camino correcto.");
        pantalla.txtMostrarContenidoDelCuento.setText(PartesDelCuento.get(indice));
        pantalla.txtMostrarContenidoDelCuento.setLineWrap(true);
        pantalla.txtMostrarContenidoDelCuento.setWrapStyleWord(true);

    }

    private void siguiente() {
       
        if(indice==PartesDelCuento.size()-1){
            indice =0;
            pantalla.txtMostrarContenidoDelCuento.setText("");
            pantalla.btmSiguiente.setVisible(false);
            pantalla.btmAbuela.setVisible(false);
            pantalla.btmCaperuza.setVisible(false);
            pantalla.btmCazador.setVisible(false);
            pantalla.btmLobo.setVisible(false);
            pantalla.btmEntorno.setVisible(false);
            pantalla.btmHablar.setVisible(false);
            pantalla.btmMoverse.setVisible(false);
            PartesDelCuento.clear();
            
            
            
            
        }else{
        switch(indice) {
        case 0:
            pantalla.btmCaperuza.setVisible(true);
            break;
        case 1:
            pantalla.btmCaperuza.setVisible(true);
            pantalla.btmEntorno.setVisible(true);
            break;
        case 2:
            pantalla.btmCaperuza.setVisible(true);
            pantalla.btmLobo.setVisible(true);
            break;
        case 3:
            pantalla.btmLobo.setVisible(true);
            pantalla.btmAbuela.setVisible(true);
            break;
        case 4:
            pantalla.btmCaperuza.setVisible(true);
            pantalla.btmLobo.setVisible(true);
            break;
        case 5:
            pantalla.btmCazador.setVisible(true);
            pantalla.btmCaperuza.setVisible(true);
            pantalla.btmAbuela.setVisible(true);
            break;
        case 6:
            pantalla.btmCaperuza.setVisible(true);
            pantalla.btmAbuela.setVisible(true);
            pantalla.btmEntorno.setVisible(true);
            break;
    }
            
        indice++;
       pantalla.txtMostrarContenidoDelCuento.setText(PartesDelCuento.get(indice));
        }
       
    }
    
   
    private void caperuza() {
        pantalla.btmHablar.setVisible(true);
        pantalla.btmMoverse.setVisible(true);
         for (ActionListener al : pantalla.btmHablar.getActionListeners()) {
        pantalla.btmHablar.removeActionListener(al);
        }
        for (ActionListener al : pantalla.btmMoverse.getActionListeners()) {
        pantalla.btmMoverse.removeActionListener(al);
        }
       pantalla.btmHablar.addActionListener((e) -> {
           caperucita1.hablar();
       });
        pantalla.btmMoverse.addActionListener((e) -> {
            caperucita1.moverse();
        });
        
    }

  private void abuela() {
    pantalla.btmHablar.setVisible(true);
    pantalla.btmMoverse.setVisible(true);

    // Limpiar acciones anteriores
    for (ActionListener al : pantalla.btmHablar.getActionListeners()) {
        pantalla.btmHablar.removeActionListener(al);
    }
    for (ActionListener al : pantalla.btmMoverse.getActionListeners()) {
        pantalla.btmMoverse.removeActionListener(al);
    }

    // Asignar nuevas acciones
    pantalla.btmHablar.addActionListener(e -> abuela1.hablar());
    pantalla.btmMoverse.addActionListener(e -> abuela1.moverse());
}

private void cazador() {
    pantalla.btmHablar.setVisible(true);
    pantalla.btmMoverse.setVisible(true);

    for (ActionListener al : pantalla.btmHablar.getActionListeners()) {
        pantalla.btmHablar.removeActionListener(al);
    }
    for (ActionListener al : pantalla.btmMoverse.getActionListeners()) {
        pantalla.btmMoverse.removeActionListener(al);
    }

    pantalla.btmHablar.addActionListener(e -> cazador1.hablar());
    pantalla.btmMoverse.addActionListener(e -> cazador1.moverse());
}

private void Entorno() {
    pantalla.btmHablar.setVisible(true);
    pantalla.btmMoverse.setVisible(true);

    for (ActionListener al : pantalla.btmHablar.getActionListeners()) {
        pantalla.btmHablar.removeActionListener(al);
    }
    for (ActionListener al : pantalla.btmMoverse.getActionListeners()) {
        pantalla.btmMoverse.removeActionListener(al);
    }

    pantalla.btmHablar.addActionListener(e -> entorno1.describir());
    pantalla.btmMoverse.addActionListener(e -> entorno1.cortarArboles());
}

private void lobo() {
    pantalla.btmHablar.setVisible(true);
    pantalla.btmMoverse.setVisible(true);

    for (ActionListener al : pantalla.btmHablar.getActionListeners()) {
        pantalla.btmHablar.removeActionListener(al);
    }
    for (ActionListener al : pantalla.btmMoverse.getActionListeners()) {
        pantalla.btmMoverse.removeActionListener(al);
    }

    pantalla.btmHablar.addActionListener(e -> lobo1.hablar());
    pantalla.btmMoverse.addActionListener(e -> lobo1.moverse());
}

 
        
        
}

package controller;

import Modelo.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.PantallaCalculadora;

/**
 * @author Cristian Daniel
 */
public class ControlPantallaCalculadora {

    private PantallaCalculadora pantalla;

    public ControlPantallaCalculadora(PantallaCalculadora pantalla) {
        this.pantalla = pantalla;
        // Al iniciar, limpiamos todo para que nazca organizada
        ocultarCampos();
        initedEvent();
    }

    public void initedEvent() {
        pantalla.btmCuadrado.addActionListener((e) -> cuadrado());
        pantalla.btmRectangulo.addActionListener((e) -> rectangulo());
        pantalla.btmRombo.addActionListener((e) -> rombo());
        pantalla.btmRomboide.addActionListener((e) -> Romboide());
        pantalla.btmTriangulo.addActionListener((e) -> triangulo());
        pantalla.btmParalelogramo.addActionListener((e) -> paralelogramo());
        
    }

    private void cuadrado() {
        ocultarCampos(); // 1. Limpiar
        pantalla.txtLado1.setVisible(true); // 2. Mostrar lo necesario
        pantalla.btmPerimetro.setVisible(true);
        pantalla.btmArea.setVisible(true);
        
        for (ActionListener a:pantalla.btmArea.getActionListeners() ) {
           pantalla.btmArea.removeActionListener(a);
        }
        
        for (ActionListener a:pantalla.btmPerimetro.getActionListeners() ) {
           pantalla.btmPerimetro.removeActionListener(a);
        }
        
        
        
        pantalla.btmArea.addActionListener((e) -> {
            if (pantalla.txtLado1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Debe ir un componente en el lado 1");
                return;
            }
            double lado = Double.parseDouble(pantalla.txtLado1.getText());
            Cuadrado c = new Cuadrado(lado, 0, 0, 0);
            JOptionPane.showMessageDialog(pantalla, "El area del cuadrado es " + c.caluclarArea());
            ocultarCampos();
        });
        pantalla.btmPerimetro.addActionListener((e) -> {
            if (pantalla.txtLado1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Debe ir un componente en el lado 1");
                return;
            }
            double lado = Double.parseDouble(pantalla.txtLado1.getText());
            Cuadrado c = new Cuadrado(lado, 0, 0, 0);
            JOptionPane.showMessageDialog(pantalla, "El Perimetro del cuadrado es " + c.caluclarPerimetro());
            ocultarCampos();
            return;
        });
    }

    private void rectangulo() {
        ocultarCampos();
       pantalla.txtLado1.setVisible(true);
        pantalla.txtLado.setVisible(true);
        pantalla.txtLado3.setVisible(true);
        pantalla.txtLado4.setVisible(true);
        pantalla.btmPerimetro.setVisible(true);
        pantalla.btmArea.setVisible(true);
        
        
        
        
         for (ActionListener a:pantalla.btmArea.getActionListeners() ) {
           pantalla.btmArea.removeActionListener(a);
        }
        
        for (ActionListener a:pantalla.btmPerimetro.getActionListeners() ) {
           pantalla.btmPerimetro.removeActionListener(a);
        }
        
        
        
        pantalla.btmArea.addActionListener((e) -> {
            if (pantalla.txtLado1.getText().isEmpty()||pantalla.txtLado.getText().isEmpty()||pantalla.txtLado3.getText().isEmpty()||pantalla.txtLado4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Debe ir un componente en el lado 1");
                return;
            }
            double lado1 = Double.parseDouble(pantalla.txtLado1.getText());
            double lado2 = Double.parseDouble(pantalla.txtLado.getText());
            double lado3 = Double.parseDouble(pantalla.txtLado3.getText());
            double lado4 = Double.parseDouble(pantalla.txtLado4.getText());
            
            Retacgulo c = new Retacgulo(lado1, lado2, lado3, lado4);
            JOptionPane.showMessageDialog(pantalla, "El area del rectangulo es " + c.caluclarArea());
            ocultarCampos();
        });
        pantalla.btmPerimetro.addActionListener((e) -> {
            if (pantalla.txtLado1.getText().isEmpty()||pantalla.txtLado.getText().isEmpty()||pantalla.txtLado3.getText().isEmpty()||pantalla.txtLado4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Debe ir un componente en el lado 1");
                return;
            }
            double lado1 = Double.parseDouble(pantalla.txtLado1.getText());
            double lado2 = Double.parseDouble(pantalla.txtLado.getText());
            double lado3 = Double.parseDouble(pantalla.txtLado3.getText());
            double lado4 = Double.parseDouble(pantalla.txtLado4.getText());
            
            Retacgulo c = new Retacgulo(lado1, lado2, lado3, lado4);
            JOptionPane.showMessageDialog(pantalla, "El perimetro del rectangulo es " + c.caluclarPerimetro());
            ocultarCampos();
        });
    }

    private void rombo() {
        for (ActionListener a:pantalla.btmArea.getActionListeners() ) {
           pantalla.btmArea.removeActionListener(a);
        }
        
        for (ActionListener a:pantalla.btmPerimetro.getActionListeners() ) {
           pantalla.btmPerimetro.removeActionListener(a);
        }
        ocultarCampos();
        pantalla.txtLado1.setVisible(true);
        pantalla.txtLado.setVisible(true);
        pantalla.txtLado3.setVisible(true);
        pantalla.txtLado4.setVisible(true);
        pantalla.txtDiagonal1.setVisible(true);
        pantalla.txtDiagonal2.setVisible(true);
        pantalla.btmPerimetro.setVisible(true);
        pantalla.btmArea.setVisible(true);
        
         pantalla.btmArea.addActionListener((e) -> {
            if (pantalla.txtLado1.getText().isEmpty()||pantalla.txtLado.getText().isEmpty()||pantalla.txtLado3.getText().isEmpty()||pantalla.txtLado4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Debe ir un componente en los lados ");
                return;
            }
            double lado1 = Double.parseDouble(pantalla.txtLado1.getText());
            double lado2 = Double.parseDouble(pantalla.txtLado.getText());
            double lado3 = Double.parseDouble(pantalla.txtLado3.getText());
            double lado4 = Double.parseDouble(pantalla.txtLado4.getText());
            double diagonal1 = Double.parseDouble(pantalla.txtDiagonal1.getText());
            double diagonal2 = Double.parseDouble(pantalla.txtDiagonal2.getText());
            
            
            Rombo c = new Rombo(lado1, lado2, lado3, lado4, diagonal1, diagonal2);
            JOptionPane.showMessageDialog(pantalla, "El area del rombo es " + c.caluclarArea());
            ocultarCampos();
            return;
        });
         
         pantalla.btmPerimetro.addActionListener((e) -> {
            if (pantalla.txtLado1.getText().isEmpty()||pantalla.txtLado.getText().isEmpty()||pantalla.txtLado3.getText().isEmpty()||pantalla.txtLado4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Debe ir un componente en el lado 1");
                return;
            }
            double lado1 = Double.parseDouble(pantalla.txtLado1.getText());
            double lado2 = Double.parseDouble(pantalla.txtLado.getText());
            double lado3 = Double.parseDouble(pantalla.txtLado3.getText());
            double lado4 = Double.parseDouble(pantalla.txtLado4.getText());
            double diagonal1 = Double.parseDouble(pantalla.txtDiagonal1.getText());
            double diagonal2 = Double.parseDouble(pantalla.txtDiagonal2.getText());
            
            
            Rombo c = new Rombo(lado1, lado2, lado3, lado4, diagonal1, diagonal2);
            JOptionPane.showMessageDialog(pantalla, "El Perimetro del rombo es " + c.caluclarPerimetro());
            ocultarCampos();
            return;
        });  
         
        
        
    }

   private void Romboide() {
        ocultarCampos();
        for (ActionListener a : pantalla.btmArea.getActionListeners()) {
            pantalla.btmArea.removeActionListener(a);
        }
        for (ActionListener a : pantalla.btmPerimetro.getActionListeners()) {
            pantalla.btmPerimetro.removeActionListener(a);
        }

        pantalla.txtBase.setVisible(true);
        pantalla.txtBaseMenor.setVisible(true);
        pantalla.txtLado.setVisible(true);
        pantalla.txtLado4.setVisible(true);
        pantalla.txtAltura.setVisible(true);
        pantalla.btmPerimetro.setVisible(true);
        pantalla.btmArea.setVisible(true);

        pantalla.btmArea.addActionListener((e) -> {
            if (pantalla.txtBase.getText().isEmpty() || pantalla.txtBaseMenor.getText().isEmpty() || pantalla.txtAltura.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Faltan las bases o la altura");
                return;
            }
            double bM = Double.parseDouble(pantalla.txtBase.getText());
            double bm = Double.parseDouble(pantalla.txtBaseMenor.getText());
            double h = Double.parseDouble(pantalla.txtAltura.getText());
            
            Trapecio t = new Trapecio(bM, 0, bm, 0, h);
            JOptionPane.showMessageDialog(pantalla, "Área del Trapecio: " + t.caluclarArea());
            ocultarCampos();
        });

        pantalla.btmPerimetro.addActionListener((e) -> {
            if (pantalla.txtBase.getText().isEmpty() || pantalla.txtLado.getText().isEmpty() || 
                pantalla.txtBaseMenor.getText().isEmpty() || pantalla.txtLado4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Faltan los cuatro lados para el perímetro");
                return;
            }
            double l1 = Double.parseDouble(pantalla.txtBase.getText());
            double l2 = Double.parseDouble(pantalla.txtLado.getText());
            double l3 = Double.parseDouble(pantalla.txtBaseMenor.getText());
            double l4 = Double.parseDouble(pantalla.txtLado4.getText());
            
            Trapecio t = new Trapecio(l1, l2, l3, l4, 0);
            JOptionPane.showMessageDialog(pantalla, "Perímetro del Trapecio: " + t.caluclarPerimetro());
            ocultarCampos();
        });
    }

    private void paralelogramo() {
        ocultarCampos();
        for (ActionListener a : pantalla.btmArea.getActionListeners()) {
            pantalla.btmArea.removeActionListener(a);
        }
        for (ActionListener a : pantalla.btmPerimetro.getActionListeners()) {
            pantalla.btmPerimetro.removeActionListener(a);
        }

        pantalla.txtBase.setVisible(true);
        pantalla.txtLado.setVisible(true);
        pantalla.txtAltura.setVisible(true);
        pantalla.btmPerimetro.setVisible(true);
        pantalla.btmArea.setVisible(true);

        pantalla.btmArea.addActionListener((e) -> {
            if (pantalla.txtBase.getText().isEmpty() || pantalla.txtAltura.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Faltan datos");
                return;
            }
            double b = Double.parseDouble(pantalla.txtBase.getText());
            double h = Double.parseDouble(pantalla.txtAltura.getText());
            Paralelogramo p = new Paralelogramo(b, 0, 0, 0, h);
            JOptionPane.showMessageDialog(pantalla, "Área: " + p.caluclarArea());
            ocultarCampos();
        });

        pantalla.btmPerimetro.addActionListener((e) -> {
            if (pantalla.txtBase.getText().isEmpty() || pantalla.txtLado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Faltan datos");
                return;
            }
            double b = Double.parseDouble(pantalla.txtBase.getText());
            double l = Double.parseDouble(pantalla.txtLado.getText());
            Paralelogramo p = new Paralelogramo(b, l, b, l, 0);
            JOptionPane.showMessageDialog(pantalla, "Perímetro: " + p.caluclarPerimetro());
            ocultarCampos();
        });
    }
   private void triangulo() {
        ocultarCampos();
        for (ActionListener a : pantalla.btmArea.getActionListeners()) {
            pantalla.btmArea.removeActionListener(a);
        }
        for (ActionListener a : pantalla.btmPerimetro.getActionListeners()) {
            pantalla.btmPerimetro.removeActionListener(a);
        }

        pantalla.txtLado1.setVisible(true);
        pantalla.txtLado.setVisible(true);
        pantalla.txtLado3.setVisible(true);
        pantalla.btmPerimetro.setVisible(true);
        pantalla.btmArea.setVisible(true);

        pantalla.btmArea.addActionListener((e) -> {
            if (pantalla.txtLado1.getText().isEmpty() || pantalla.txtLado.getText().isEmpty() || pantalla.txtLado3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Faltan los lados");
                return;
            }
            double l1 = Double.parseDouble(pantalla.txtLado1.getText());
            double l2 = Double.parseDouble(pantalla.txtLado.getText());
            double l3 = Double.parseDouble(pantalla.txtLado3.getText());
            Triangulo t = new Triangulo(l1, l2, l3);
            JOptionPane.showMessageDialog(pantalla, "Área: " + t.calcularArea());
            ocultarCampos();
        });

        pantalla.btmPerimetro.addActionListener((e) -> {
            if (pantalla.txtLado1.getText().isEmpty() || pantalla.txtLado.getText().isEmpty() || pantalla.txtLado3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pantalla, "Faltan los lados");
                return;
            }
            double l1 = Double.parseDouble(pantalla.txtLado1.getText());
            double l2 = Double.parseDouble(pantalla.txtLado.getText());
            double l3 = Double.parseDouble(pantalla.txtLado3.getText());
            Triangulo t = new Triangulo(l1, l2, l3);
            JOptionPane.showMessageDialog(pantalla, "Perímetro: " + t.calcularPerimetro());
            ocultarCampos();
        });
    }

    
    private void ocultarCampos() {
        pantalla.txtLado1.setVisible(false);
        pantalla.txtLado.setVisible(false);
        pantalla.txtLado3.setVisible(false);
        pantalla.txtLado4.setVisible(false);
        pantalla.txtBase.setVisible(false);
        pantalla.txtBaseMenor.setVisible(false);
        pantalla.txtAltura.setVisible(false);
        pantalla.txtDiagonal1.setVisible(false);
        pantalla.txtDiagonal2.setVisible(false);
        pantalla.btmPerimetro.setVisible(false);
        pantalla.btmArea.setVisible(false);
        
        
        pantalla.txtLado1.setText("");
        pantalla.txtLado.setText("");
        pantalla.txtLado3.setText("");
        pantalla.txtLado4.setText("");
        pantalla.txtBase.setText("");
        pantalla.txtBaseMenor.setText("");
        pantalla.txtAltura.setText("");
        pantalla.txtDiagonal1.setText("");
        pantalla.txtDiagonal2.setText("");
        // Forzar actualización visual
        pantalla.repaint();
        pantalla.revalidate();
    }

}


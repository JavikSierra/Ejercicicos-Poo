package vista;

import modelo.Personaje;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class JFSimulacionChavo extends javax.swing.JFrame {

    // Componentes públicos para que el controlador los acceda
    public javax.swing.JLabel lblChavo;
    public javax.swing.JLabel lblQuico;
    public javax.swing.JLabel lblDonRamon;
    public javax.swing.JLabel lblDonaFlorinda;

    public javax.swing.JButton btnBarril;
    public javax.swing.JButton btnCasa1;
    public javax.swing.JButton btnCasa2;
    public javax.swing.JButton btnCasa3;
    public javax.swing.JButton btnInteractuar;

    public javax.swing.JComboBox<Personaje> cmbPersonaje1;
    public javax.swing.JComboBox<Personaje> cmbPersonaje2;

    public javax.swing.JTextArea AreaResults;

    public JFSimulacionChavo() {
        // Configurar título y comportamiento por defecto
        setTitle("Simulación de la Vecindad del Chavo");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Inicializar componentes
        initComponents();

        // Centrar ventana en pantalla
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        // Colores temáticos inspirados en la vecindad
        Color colorFondo = new Color(245, 242, 235); // Beige claro / barro seco
        Color colorHeader = new Color(139, 90, 43); // Café madera vieja
        Color colorBoton = new Color(101, 67, 33); // Café oscuro
        Color colorBotonAccion = new Color(46, 117, 89); // Verde rústico
        Color colorTexto = new Color(51, 34, 17); // Marrón oscuro
        Color colorCard = new Color(230, 224, 211); // Beige más oscuro para tarjetas

        Font fontTitulo = new Font("Segoe UI", Font.BOLD, 22);
        Font fontSubtitulo = new Font("Segoe UI", Font.BOLD, 14);
        Font fontGeneral = new Font("Segoe UI", Font.PLAIN, 13);
        Font fontMonospaced = new Font("Consolas", Font.PLAIN, 13);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(15, 15));
        panelPrincipal.setBackground(colorFondo);
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(panelPrincipal);

        // --- ENCABEZADO ---
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBackground(colorHeader);
        panelHeader.setBorder(new EmptyBorder(12, 20, 12, 20));

        JLabel lblTitulo = new JLabel("La Vecindad del Chavo - Simulación de Interacciones");
        lblTitulo.setFont(fontTitulo);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelHeader.add(lblTitulo, BorderLayout.CENTER);
        panelPrincipal.add(panelHeader, BorderLayout.NORTH);

        // --- CUERPO PRINCIPAL ---
        JPanel panelCuerpo = new JPanel(new GridLayout(1, 2, 15, 0));
        panelCuerpo.setBackground(colorFondo);

        // Panel Izquierdo: Patio (Personajes)
        JPanel panelPatio = new JPanel();
        panelPatio.setLayout(new BoxLayout(panelPatio, BoxLayout.Y_AXIS));
        panelPatio.setBackground(colorFondo);
        panelPatio.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorHeader, 2, true),
                " Patio de la Vecindad (Personajes Presentes) ",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                fontSubtitulo,
                colorHeader));

        // Crear las etiquetas de los personajes como "tarjetas" visuales
        lblChavo = crearEtiquetaPersonaje("  El Chavo (En el Patio) ", colorCard, colorTexto, fontGeneral);
        lblQuico = crearEtiquetaPersonaje("  Quico (En el Patio) ", colorCard, colorTexto, fontGeneral);
        lblDonRamon = crearEtiquetaPersonaje("  Don Ramón (En el Patio) ", colorCard, colorTexto, fontGeneral);
        lblDonaFlorinda = crearEtiquetaPersonaje("  Doña Florinda (En el Patio) ", colorCard, colorTexto, fontGeneral);

        panelPatio.add(Box.createVerticalStrut(15));
        panelPatio.add(lblChavo);
        panelPatio.add(Box.createVerticalStrut(12));
        panelPatio.add(lblQuico);
        panelPatio.add(Box.createVerticalStrut(12));
        panelPatio.add(lblDonRamon);
        panelPatio.add(Box.createVerticalStrut(12));
        panelPatio.add(lblDonaFlorinda);
        panelPatio.add(Box.createVerticalGlue());

        // Panel Derecho: Refugios (Botones de control)
        JPanel panelRefugios = new JPanel(new GridBagLayout());
        panelRefugios.setBackground(colorFondo);
        panelRefugios.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorHeader, 2, true),
                " Control de Refugios (Entrar / Salir) ",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                fontSubtitulo,
                colorHeader));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.weightx = 1.0;
        gbc.gridx = 0;

        btnBarril = crearBotonEstilo(" Usar Barril (El Chavo)", colorBoton, fontGeneral);
        btnCasa1 = crearBotonEstilo(" Casa N° 14 (Doña Florinda)", colorBoton, fontGeneral);
        btnCasa2 = crearBotonEstilo(" Casa N° 15 (Quico)", colorBoton, fontGeneral);
        btnCasa3 = crearBotonEstilo(" Casa N° 72 (Don Ramón)", colorBoton, fontGeneral);

        gbc.gridy = 0;
        panelRefugios.add(btnBarril, gbc);
        gbc.gridy = 1;
        panelRefugios.add(btnCasa1, gbc);
        gbc.gridy = 2;
        panelRefugios.add(btnCasa2, gbc);
        gbc.gridy = 3;
        panelRefugios.add(btnCasa3, gbc);

        panelCuerpo.add(panelPatio);
        panelCuerpo.add(panelRefugios);
        panelPrincipal.add(panelCuerpo, BorderLayout.CENTER);

        // --- PIE DE PÁGINA (INTERACCIONES Y RESULTADOS) ---
        JPanel panelSur = new JPanel(new BorderLayout(0, 10));
        panelSur.setBackground(colorFondo);
        panelSur.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorHeader, 2, true),
                " Interacciones de Personajes ",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                fontSubtitulo,
                colorHeader));

        // Panel de Selección para interacción
        JPanel panelInteraccion = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelInteraccion.setBackground(colorFondo);

        JLabel lblDe = new JLabel("Personaje 1:");
        lblDe.setFont(fontGeneral);
        lblDe.setForeground(colorTexto);

        cmbPersonaje1 = new JComboBox<>();
        cmbPersonaje1.setFont(fontGeneral);
        cmbPersonaje1.setPreferredSize(new Dimension(160, 28));

        JLabel lblA = new JLabel("con:");
        lblA.setFont(fontGeneral);
        lblA.setForeground(colorTexto);

        cmbPersonaje2 = new JComboBox<>();
        cmbPersonaje2.setFont(fontGeneral);
        cmbPersonaje2.setPreferredSize(new Dimension(160, 28));

        btnInteractuar = crearBotonEstilo(" ¡Interactuar!", colorBotonAccion, fontGeneral);
        btnInteractuar.setPreferredSize(new Dimension(130, 28));

        panelInteraccion.add(lblDe);
        panelInteraccion.add(cmbPersonaje1);
        panelInteraccion.add(lblA);
        panelInteraccion.add(cmbPersonaje2);
        panelInteraccion.add(btnInteractuar);
        panelSur.add(panelInteraccion, BorderLayout.NORTH);

        // Área de resultados con Scroll
        AreaResults = new JTextArea();
        AreaResults.setFont(fontGeneral);
        AreaResults.setEditable(false);
        AreaResults.setLineWrap(true);
        AreaResults.setWrapStyleWord(true);
        AreaResults.setBackground(Color.WHITE);
        AreaResults.setForeground(colorTexto);
        AreaResults.setMargin(new Insets(8, 8, 8, 8));

        JScrollPane scrollResults = new JScrollPane(AreaResults);
        scrollResults.setPreferredSize(new Dimension(0, 120));
        scrollResults.setBorder(BorderFactory.createLineBorder(colorHeader, 1));
        panelSur.add(scrollResults, BorderLayout.CENTER);

        panelPrincipal.add(panelSur, BorderLayout.SOUTH);

        // Tamaño preferido de la ventana
        setPreferredSize(new Dimension(720, 600));
    }

    private JLabel crearEtiquetaPersonaje(String texto, Color bg, Color fg, Font font) {
        JLabel label = new JLabel(texto);
        label.setFont(font);
        label.setForeground(fg);
        label.setBackground(bg);
        label.setOpaque(true);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setMaximumSize(new Dimension(280, 40));
        label.setPreferredSize(new Dimension(280, 40));
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 170, 150), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        return label;
    }

    private JButton crearBotonEstilo(String texto, Color bg, Font font) {
        JButton boton = new JButton(texto);
        boton.setFont(font);
        boton.setForeground(Color.WHITE);
        boton.setBackground(bg);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(bg.darker(), 1),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)));

        // Efecto hover simple
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(bg.brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(bg);
            }
        });

        return boton;
    }
}

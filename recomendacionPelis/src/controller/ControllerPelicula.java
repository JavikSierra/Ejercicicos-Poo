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
public class ControllerPelicula {
    
    private JFPelicula frmPelicula;
    private ArrayList<Pelicula> listaPeliculas;
    
    
    public ControllerPelicula(JFPelicula frmPelicula) {
        this.frmPelicula = frmPelicula;
        this.listaPeliculas = new ArrayList();
        initEvents();
        cargarPeliculas();
        
    }

    private void initEvents() {

         this.frmPelicula.btnEnviar.addActionListener(e->registrar());
        this.frmPelicula.btnMostrar.addActionListener(e->mostrar());
        this.frmPelicula.cmbGenero.setModel(new DefaultComboBoxModel(Genero.values()));
     }

    private void registrar() {


    try {

        String nombre = frmPelicula.txtComentario.getText();

        Genero genero =
                (Genero) frmPelicula.cmbGenero.getSelectedItem();

        String duracion = frmPelicula.txtComentario1.getText();

        String anio = frmPelicula.txtComentario2.getText();

        String director = frmPelicula.txtComentario3.getText();

        Pelicula pelicula = new Pelicula(
                anio,
                0.0,
                director,
                duracion,
                genero,
                new ArrayList<>(),
                nombre
        );

        listaPeliculas.add(pelicula);

        frmPelicula.areaResults.setText(
                "PELICULA REGISTRADA CORRECTAMENTE"
        );

        frmPelicula.txtComentario.setText("");
        frmPelicula.txtComentario1.setText("");
        frmPelicula.txtComentario2.setText("");
        frmPelicula.txtComentario3.setText("");

    } catch (Exception e) {

        frmPelicula.areaResults.setText(
                "ERROR AL REGISTRAR"
        );

    }

}

    

    
     
        
        


    


   private void cargarPeliculas() {

    Genero accion = Genero.ACCION;
    Genero drama = Genero.DRAMA;
    Genero comedia = Genero.COMEDIA;
    Genero terror = Genero.TERROR;
    Genero cienciaFic = Genero.CIENCIA_FICCION;
    Genero animacion = Genero.ANIMACION;
    Genero thriller = Genero.THRILLER;
    Genero romance = Genero.ROMANCE;
    Genero fantasia = Genero.FANTASIA;
    Genero documental = Genero.DOCUMENTAL;

    // ===================== ACCION =====================

    listaPeliculas.add(new Pelicula("2008", 0.0, "Christopher Nolan", "152 min", accion, new ArrayList<>(), "El Caballero de la Noche"));
    listaPeliculas.add(new Pelicula("2000", 0.0, "Ridley Scott", "155 min", accion, new ArrayList<>(), "Gladiador"));
    listaPeliculas.add(new Pelicula("2003", 0.0, "Peter Jackson", "201 min", accion, new ArrayList<>(), "El Senor de los Anillos: El Retorno del Rey"));
    listaPeliculas.add(new Pelicula("1984", 0.0, "James Cameron", "107 min", accion, new ArrayList<>(), "Terminator"));
    listaPeliculas.add(new Pelicula("1988", 0.0, "John McTiernan", "132 min", accion, new ArrayList<>(), "Duro de Matar"));

    // ===================== DRAMA =====================

    listaPeliculas.add(new Pelicula("1994", 0.0, "Frank Darabont", "142 min", drama, new ArrayList<>(), "Cadena Perpetua"));
    listaPeliculas.add(new Pelicula("1972", 0.0, "Francis Ford Coppola", "175 min", drama, new ArrayList<>(), "El Padrino"));
    listaPeliculas.add(new Pelicula("1994", 0.0, "Robert Zemeckis", "142 min", drama, new ArrayList<>(), "Forrest Gump"));
    listaPeliculas.add(new Pelicula("1993", 0.0, "Steven Spielberg", "195 min", drama, new ArrayList<>(), "La Lista de Schindler"));
    listaPeliculas.add(new Pelicula("1997", 0.0, "James Cameron", "194 min", drama, new ArrayList<>(), "Titanic"));

    // ===================== COMEDIA =====================

    listaPeliculas.add(new Pelicula("2011", 0.0, "Michel Hazanavicius", "100 min", comedia, new ArrayList<>(), "El Artista"));
    listaPeliculas.add(new Pelicula("2014", 0.0, "Wes Anderson", "100 min", comedia, new ArrayList<>(), "El Gran Hotel Budapest"));
    listaPeliculas.add(new Pelicula("2022", 0.0, "Ruben Ostlund", "147 min", comedia, new ArrayList<>(), "Triangle of Sadness"));
    listaPeliculas.add(new Pelicula("1959", 0.0, "Billy Wilder", "121 min", comedia, new ArrayList<>(), "Con Faldas y a lo Loco"));
    listaPeliculas.add(new Pelicula("1998", 0.0, "Roberto Benigni", "116 min", comedia, new ArrayList<>(), "La Vida es Bella"));

    // ===================== TERROR =====================

    listaPeliculas.add(new Pelicula("1980", 0.0, "Stanley Kubrick", "146 min", terror, new ArrayList<>(), "El Resplandor"));
    listaPeliculas.add(new Pelicula("2017", 0.0, "Jordan Peele", "104 min", terror, new ArrayList<>(), "Huye"));
    listaPeliculas.add(new Pelicula("1973", 0.0, "William Friedkin", "122 min", terror, new ArrayList<>(), "El Exorcista"));
    listaPeliculas.add(new Pelicula("1960", 0.0, "Alfred Hitchcock", "109 min", terror, new ArrayList<>(), "Psicosis"));
    listaPeliculas.add(new Pelicula("2018", 0.0, "Ari Aster", "127 min", terror, new ArrayList<>(), "Hereditary"));

    // ===================== CIENCIA FICCION =====================

    listaPeliculas.add(new Pelicula("1999", 0.0, "Lana Wachowski", "136 min", cienciaFic, new ArrayList<>(), "The Matrix"));
    listaPeliculas.add(new Pelicula("2010", 0.0, "Christopher Nolan", "148 min", cienciaFic, new ArrayList<>(), "Inception"));
    listaPeliculas.add(new Pelicula("2014", 0.0, "Christopher Nolan", "169 min", cienciaFic, new ArrayList<>(), "Interstellar"));
    listaPeliculas.add(new Pelicula("2009", 0.0, "James Cameron", "162 min", cienciaFic, new ArrayList<>(), "Avatar"));
    listaPeliculas.add(new Pelicula("2013", 0.0, "Alfonso Cuaron", "91 min", cienciaFic, new ArrayList<>(), "Gravity"));

    // ===================== ANIMACION =====================

    listaPeliculas.add(new Pelicula("2004", 0.0, "Brad Bird", "115 min", animacion, new ArrayList<>(), "Los Increibles"));
    listaPeliculas.add(new Pelicula("2010", 0.0, "Lee Unkrich", "103 min", animacion, new ArrayList<>(), "Toy Story 3"));
    listaPeliculas.add(new Pelicula("2001", 0.0, "Hayao Miyazaki", "125 min", animacion, new ArrayList<>(), "El Viaje de Chihiro"));
    listaPeliculas.add(new Pelicula("2016", 0.0, "Byron Howard", "108 min", animacion, new ArrayList<>(), "Zootopia"));
    listaPeliculas.add(new Pelicula("2009", 0.0, "Pete Docter", "96 min", animacion, new ArrayList<>(), "Up"));

    // ===================== THRILLER =====================

    listaPeliculas.add(new Pelicula("1994", 0.0, "Quentin Tarantino", "154 min", thriller, new ArrayList<>(), "Pulp Fiction"));
    listaPeliculas.add(new Pelicula("1999", 0.0, "David Fincher", "139 min", thriller, new ArrayList<>(), "El Club de la Pelea"));
    listaPeliculas.add(new Pelicula("1995", 0.0, "David Fincher", "127 min", thriller, new ArrayList<>(), "Seven"));
    listaPeliculas.add(new Pelicula("2019", 0.0, "Bong Joon-ho", "132 min", thriller, new ArrayList<>(), "Parasite"));
    listaPeliculas.add(new Pelicula("1991", 0.0, "Jonathan Demme", "118 min", thriller, new ArrayList<>(), "El Silencio de los Inocentes"));

    // ===================== ROMANCE =====================

    listaPeliculas.add(new Pelicula("2004", 0.0, "Michel Gondry", "108 min", romance, new ArrayList<>(), "Eterno Resplandor de una Mente sin Recuerdos"));
    listaPeliculas.add(new Pelicula("1942", 0.0, "Michael Curtiz", "102 min", romance, new ArrayList<>(), "Casablanca"));
    listaPeliculas.add(new Pelicula("1999", 0.0, "Roger Michell", "124 min", romance, new ArrayList<>(), "Notting Hill"));
    listaPeliculas.add(new Pelicula("2013", 0.0, "Spike Jonze", "126 min", romance, new ArrayList<>(), "Her"));
    listaPeliculas.add(new Pelicula("2016", 0.0, "Damien Chazelle", "128 min", romance, new ArrayList<>(), "La La Land"));

    // ===================== FANTASIA =====================

    listaPeliculas.add(new Pelicula("2001", 0.0, "Peter Jackson", "178 min", fantasia, new ArrayList<>(), "El Senor de los Anillos: La Comunidad del Anillo"));
    listaPeliculas.add(new Pelicula("2001", 0.0, "Chris Columbus", "152 min", fantasia, new ArrayList<>(), "Harry Potter y la Piedra Filosofal"));
    listaPeliculas.add(new Pelicula("2010", 0.0, "Tim Burton", "108 min", fantasia, new ArrayList<>(), "Alicia en el Pais de las Maravillas"));
    listaPeliculas.add(new Pelicula("1985", 0.0, "Robert Zemeckis", "116 min", fantasia, new ArrayList<>(), "Regreso al Futuro"));
    listaPeliculas.add(new Pelicula("2006", 0.0, "Guillermo del Toro", "118 min", fantasia, new ArrayList<>(), "El Laberinto del Fauno"));

    // ===================== DOCUMENTAL =====================

    listaPeliculas.add(new Pelicula("2011", 0.0, "Asif Kapadia", "100 min", documental, new ArrayList<>(), "Senna"));
    listaPeliculas.add(new Pelicula("2004", 0.0, "Morgan Spurlock", "100 min", documental, new ArrayList<>(), "Super Size Me"));
    listaPeliculas.add(new Pelicula("2006", 0.0, "Davis Guggenheim", "100 min", documental, new ArrayList<Comentario>(), "Una Verdad Incomoda"));
    listaPeliculas.add(new Pelicula("2013", 0.0, "Asif Kapadia", "128 min", documental, new ArrayList<Comentario>(), "Amy"));
    listaPeliculas.add(new Pelicula("2005", 0.0, "Werner Herzog", "103 min", documental, new ArrayList<Comentario>(), "Grizzly Man"));

}

    private void mostrar() {

         frmPelicula.areaResults.setText("");

    Genero generoSeleccionado =
            (Genero) frmPelicula.cmbGenero.getSelectedItem();

    for (Pelicula p : listaPeliculas) {

        if (p.getGenero() == generoSeleccionado) {

            frmPelicula.areaResults.append(

                    "Nombre: " + p.getNombre() +
                    "\nGenero: " + p.getGenero() +
                    "\nDuracion: " + p.getDuracion() +
                    "\nAño: " + p.getAnio() +
                    "\nDirector: " + p.getDirector() +
                    "\nCalificacion: " + p.getCalificacionPromedio() +
                    "\n===========================\n"

            );

        }

    }

    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }
    
    
    
    
}

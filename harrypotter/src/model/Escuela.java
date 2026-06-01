package model;

import java.util.ArrayList;

public class Escuela {

    private String nombre;

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Profesor> profesores;
    private ArrayList<Locacion> locaciones;
    private ArrayList<Hechizo> hechizos;
    private ArrayList<ObjetoMagico> objetos;
    private ArrayList<ClaseMagica> clases;

    public Escuela(String nombre) {

        this.nombre = nombre;

        estudiantes = new ArrayList<>();
        profesores = new ArrayList<>();
        locaciones = new ArrayList<>();
        hechizos = new ArrayList<>();
        objetos = new ArrayList<>();
        clases = new ArrayList<>();

        cargarLocaciones();
    }

    public void cargarLocaciones() {

        locaciones.add(new Locacion(
                "Gran Comedor",
                "Lugar donde comen los estudiantes de Hogwarts.",
                "Las velas flotan mágicamente sobre las mesas."
        ));

        locaciones.add(new Locacion(
                "Bosque Prohibido",
                "Bosque lleno de criaturas mágicas.",
                "Existe un sendero oculto utilizado por centauros."
        ));

        locaciones.add(new Locacion(
                "Sala de los Menesteres",
                "Aparece cuando alguien la necesita.",
                "Su entrada solo aparece a quienes la buscan realmente."
        ));

        locaciones.add(new Locacion(
                "Torre de Astronomia",
                "La torre más alta de Hogwarts.",
                "Desde aquí se puede observar una puerta secreta."
        ));

        locaciones.add(new Locacion(
                "Camara de los Secretos",
                "Antigua cámara escondida bajo el castillo.",
                "Solo puede abrirse mediante pársel."
        ));
    }

    // AGREGAR

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void agregarProfesor(Profesor p) {
        profesores.add(p);
    }

    public void agregarLocacion(Locacion l) {
        locaciones.add(l);
    }

    public void agregarHechizo(Hechizo h) {
        hechizos.add(h);
    }

    public void agregarObjeto(ObjetoMagico o) {
        objetos.add(o);
    }

    public void agregarClase(ClaseMagica c) {
        clases.add(c);
    }

    // ELIMINAR

    public void eliminarEstudiante(int pos) {
        estudiantes.remove(pos);
    }

    public void eliminarProfesor(int pos) {
        profesores.remove(pos);
    }

    public void eliminarLocacion(int pos) {
        locaciones.remove(pos);
    }

    public void eliminarHechizo(int pos) {
        hechizos.remove(pos);
    }

    public void eliminarObjeto(int pos) {
        objetos.remove(pos);
    }

    public void eliminarClase(int pos) {
        clases.remove(pos);
    }

    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public ArrayList<Locacion> getLocaciones() {
        return locaciones;
    }

    public void setLocaciones(ArrayList<Locacion> locaciones) {
        this.locaciones = locaciones;
    }

    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(ArrayList<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public ArrayList<ObjetoMagico> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<ObjetoMagico> objetos) {
        this.objetos = objetos;
    }

    public ArrayList<ClaseMagica> getClases() {
        return clases;
    }

    public void setClases(ArrayList<ClaseMagica> clases) {
        this.clases = clases;
    }
}
package model;

public class ClaseMagica {

    private String tema;
    private Profesor profesor;
    private Estudiante estudiante;
    private Hechizo hechizo;

    public ClaseMagica(Profesor profesor,
            Estudiante estudiante, Hechizo hechizo,String tema) {

        this.tema = tema;
        this.profesor = profesor;
        this.estudiante = estudiante;
        this.hechizo = hechizo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Hechizo getHechizo() {
        return hechizo;
    }

    public void setHechizo(Hechizo hechizo) {
        this.hechizo = hechizo;
    }

    @Override
    public String toString() {
        return tema;
    }
}
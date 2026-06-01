package model;

public class AlgoritmoDeRecomendacion {
    protected String nombre;
    protected String criterioPrincipal;
    protected String limiteDeRecomendaciones;

    public AlgoritmoDeRecomendacion() {
    }

    public AlgoritmoDeRecomendacion(String nombre, String criterioPrincipal, String limiteDeRecomendaciones) {
        this.nombre = nombre;
        this.criterioPrincipal = criterioPrincipal;
        this.limiteDeRecomendaciones = limiteDeRecomendaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCriterioPrincipal() {
        return criterioPrincipal;
    }

    public void setCriterioPrincipal(String criterioPrincipal) {
        this.criterioPrincipal = criterioPrincipal;
    }

    public String getLimiteDeRecomendaciones() {
        return limiteDeRecomendaciones;
    }

    public void setLimiteDeRecomendaciones(String limiteDeRecomendaciones) {
        this.limiteDeRecomendaciones = limiteDeRecomendaciones;
    }



}

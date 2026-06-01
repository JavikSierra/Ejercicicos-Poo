
package model;


public class Voto {
    

    private boolean blanco;
    private Candidato candidato;
    private boolean esNulo;
    private String tipoVoto;

    public Voto(boolean blanco, Candidato candidato, boolean esNulo, String tipoVoto) {
        this.blanco = blanco;
        this.candidato = candidato;
        this.esNulo = esNulo;
        this.tipoVoto = tipoVoto;
    }

 
  

    public boolean isBlanco() {
        return blanco;
    }

    public void setBlanco(boolean blanco) {
        this.blanco = blanco;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public boolean isEsNulo() {
        return esNulo;
    }

    public void setEsNulo(boolean esNulo) {
        this.esNulo = esNulo;
    }

    public String getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(String tipoVoto) {
        this.tipoVoto = tipoVoto;
    }
    
    
            
}
package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    private String idPrestamo;
    private Usuario usuario;
    private Copia copia;
    private EstadoPrestamo estadoPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private double multa;

    public Prestamo() {
    }

    public Prestamo(String idPrestamo, Usuario usuario,
                    Copia copia, EstadoPrestamo estadoPrestamo,
                    LocalDate fechaPrestamo,
                    LocalDate fechaDevolucion) {

        this.idPrestamo = idPrestamo;
        this.usuario = usuario;
        this.copia = copia;
        this.estadoPrestamo = estadoPrestamo; // SOLO PRESTADO al crear
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = 0;
    }

   

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMulta() {
        return multa;
    }

   
     
    public EstadoPrestamo estadoActual() {

        if (estadoPrestamo == EstadoPrestamo.DEVUELTO) {
            return EstadoPrestamo.DEVUELTO;
        }

        if (LocalDate.now().isAfter(fechaDevolucion)) {
            return EstadoPrestamo.MULTADO;
        }

        return EstadoPrestamo.PRESTADO;
    }

    /**
     * true si ya está vencido
     */
    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaDevolucion);
    }

    /**
     * Calcula multa SOLO si está vencido
     */
    public void calcularMulta() {

        if (!estaVencido()) {
            multa = 0;
            return;
        }

        long dias = ChronoUnit.DAYS.between(fechaDevolucion, LocalDate.now());
        multa = dias * 1000; // puedes cambiar valor por día
    }

 
    public void marcarDevuelto() {
        estadoPrestamo = EstadoPrestamo.DEVUELTO;
        calcularMulta();
    }
}



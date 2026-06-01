package modelo;

import java.util.ArrayList;

public class Cliente extends Persona{
    private String telefono;
    private Mascota mascota;
    private Reserva reserva;


    public Cliente() {
    }

    public Cliente(String nombre, String cedula, String telefono, Mascota mascota, Reserva reserva) {
        super(nombre, cedula);
        this.telefono = telefono;
        this.mascota = mascota;
        this.reserva = reserva;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author laptop
 */
public class Reserva {
    private LocalDate fechasalida;
    private LocalDate fechallegada;
    private int id;
    private LocalDate fechareserva;
    private int idCliente;
    private int idEmpleado;

    public Reserva(LocalDate fechasalida, LocalDate fechallegada, LocalDate fechareserva) {
        this.fechasalida = fechasalida;
        this.fechallegada = fechallegada;
        this.fechareserva = fechareserva;
       
    }

    @Override
    public String toString() {
        return "Reserva{" + "fechasalida=" + fechasalida + ", fechallegada=" + fechallegada + ", id=" + id + ", fechareserva=" + fechareserva + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado + '}';
    }

    public LocalDate getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(LocalDate fechasalida) {
        this.fechasalida = fechasalida;
    }

    public LocalDate getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(LocalDate fechallegada) {
        this.fechallegada = fechallegada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(LocalDate fechareserva) {
        this.fechareserva = fechareserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}

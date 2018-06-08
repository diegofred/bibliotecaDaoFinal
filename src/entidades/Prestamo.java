/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.Lector;
import entidades.Copia;
import java.util.Date;

/**
 *
 * @author Alumno
 */
public class Prestamo {

    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Copia copia;
    private Lector lector;

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Prestamo() {

    }

    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Copia copia, Lector lector) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.copia = copia;
        this.copia.setEstado(Copia.PRESTADO)  ;
        this.lector = lector;
        this.lector.agregarPrestamo(this);
    }

    public Prestamo(Date fechaPrestamo, Copia copia, Lector lector) {
        this.fechaPrestamo = fechaPrestamo;
        this.copia = copia;
        this.copia.setEstado(Copia.PRESTADO);
        this.lector = lector;
        this.lector.agregarPrestamo(this);
    }

    public void devolverPrestamo() {
        this.fechaDevolucion = new Date();
        this.copia.setEstado(Copia.EN_BIBLIOTECA);
    }

    public boolean correspondeMulta() {
        if (this.fechaPrestamo.after(this.fechaDevolucion)) {
            return false;
        } else {
            return true;
        }
    }
}

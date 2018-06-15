/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import entidades.Prestamo;

/**
 *
 * @author Alumno
 */
public class Multa {
    private Date fecha;
    private int cantidadDias;
    private Prestamo prestamo;
    private Cancelacion cancelacion;
    private Multa(){
    
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Cancelacion getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(Cancelacion cancelacion) {
        this.cancelacion = cancelacion;
    }
    
    public Multa(Date fecha, Prestamo prestamo){
        this.fecha = fecha;
        this.prestamo = prestamo;
    }

    public Multa(Date fecha, int cantidadDias, Prestamo prestamo) {
        this.fecha = fecha;
        this.cantidadDias = cantidadDias;
        this.prestamo = prestamo;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }
    
}

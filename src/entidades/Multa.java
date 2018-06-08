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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Alumno
 */
public class Cancelacion {
    private double valorDiaPendiente;
    private Date fechaCancelacion;
    private int cantidadDias;
    private Multa multa;

    public double getValorDiaPendiente() {
        return valorDiaPendiente;
    }

    public void setValorDiaPendiente(double valorDiaPendiente) {
        this.valorDiaPendiente = valorDiaPendiente;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }
    
}

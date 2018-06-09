/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alumno
 */
public class Autor {
    private String nombre;
    private String nacionalidad;
    private Date fechaNacimiento;
    
    public Autor(){
    
    }
    public Autor(String nombre, String nacionalidad, Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "\nNombre:" + this.nombre + "\nNacionalidad: " + this.nacionalidad + "\nFecha de Nacimiento: " + this.fechaNacimiento;
    }
    public String printFechaNacimiento(){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");       
        String fechaString = df.format(this.fechaNacimiento);
        return fechaString;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}

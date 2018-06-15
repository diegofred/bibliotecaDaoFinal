/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static javafx.scene.input.KeyCode.L;

/**
 *
 * @author Alumno
 */
public class Lector {
    private static int siguienteNumeroLector = 1;
            
            
            
    private int dni;
    private String apellido;
    private String nombre;
    private int numeroLector= siguienteNumeroLector++;
    
    
   /// private Multa multa;
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public Lector(int dni, String apellido, String nombre) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre= nombre;
    
    }

    
    public List<Prestamo> prestamosVigentes(){
        List<Prestamo> prestamosVigentes = new ArrayList();
        for (Prestamo p : prestamos) {
            if (!p.estaFinalizado()) {
                prestamosVigentes.add(p);
            }
        }
        return prestamosVigentes;
    }
    
    public int getNumeroLector() {
        return numeroLector;
    }
    
    public Lector(){
    
    }
    
    public Lector(int dni, String apellido, ArrayList <Prestamo> prestamos, String nombre) {
        this.dni = dni;
        this.apellido = apellido;
 
        this.prestamos = prestamos;
        this.nombre = nombre;
    }
    

    public void pedirLibro(Copia copia) throws PrestamoException {
        if (!this.tieneMulta()) {
            if (copia.EN_BIBLIOTECA.equals(copia.getEstado())) {
                Date fechaPrestamo = new Date();
                Prestamo nuevoPrestamo = new Prestamo(fechaPrestamo,copia,this);
                prestamos.add(nuevoPrestamo);
            }else{
                throw new PrestamoException();
            }
        }else{
        throw new PrestamoException();
        }
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void agregarPrestamo(Prestamo prestamo){
        this.prestamos.add(prestamo);
        prestamo.setLector(this);
    }    
    public boolean tieneMulta() {
        if (this.prestamos.isEmpty()) {
            return false;
        }
        for (Prestamo prestamo : prestamos) {
            Date fechaPrestamo = prestamo.getFechaPrestamo();
            Date fechaDevolucion = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(fechaPrestamo);
            c.add(Calendar.DATE, 30);
            Date fechaMaximaPrestama = c.getTime();
            if (fechaMaximaPrestama.after(fechaDevolucion)) {
                return false;
            } else {
                return true;
            }
        }

        return true;
    }

    @Override
    public String toString() {
       return  nombre + " " + apellido;
    }
    
}

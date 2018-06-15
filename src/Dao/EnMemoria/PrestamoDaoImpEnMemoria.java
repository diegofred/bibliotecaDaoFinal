/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import entidades.Prestamo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class PrestamoDaoImpEnMemoria implements Dao.PrestamoDao {
    
    private static final List <Prestamo> listaPrestamos = new ArrayList();
    @Override
    public List<Prestamo> obtenerPrestamos() {
        return listaPrestamos;
    }

    @Override
    public void guardarPrestamo(Prestamo p) {
        listaPrestamos.add(p);
    }

    @Override
    public void eliminarPrestamo(Prestamo p) {
        listaPrestamos.remove(p);
    }

    @Override
    public List<Prestamo> obtenerPrestamosNoDevueltos() {
        List<Prestamo> prestamos = this.obtenerPrestamos();
        List<Prestamo> prestamosNoDevueltos = new ArrayList() ;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaDevolucion() == null) {
                prestamosNoDevueltos.add(prestamo);
            }
        }
        return prestamosNoDevueltos;
    }
    
}

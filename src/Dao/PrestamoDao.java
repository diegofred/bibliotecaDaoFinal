/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.Prestamo;
import java.util.List;
/**
 *
 * @author Alumno
 */
public interface PrestamoDao {
    List<Prestamo> obtenerPrestamos();
    void guardarPrestamo(Prestamo p);
    void eliminarPrestamo(Prestamo p);
}

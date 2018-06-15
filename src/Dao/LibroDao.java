/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Libro;
import java.util.List;
import entidades.Copia;
/**
 *
 * @author Alumno
 */
public interface LibroDao {
    List<Libro> obtenerLibros();
    Libro obtenerLibroPorTitulo(String nombreLibro);
    void agregarCopias(Copia copia, Libro libro);
    void guardarLibro(Libro p);
    void eliminarLibro(Libro p);
}

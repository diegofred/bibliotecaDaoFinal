/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import Dao.LibroDao;
import entidades.Libro;
import java.util.ArrayList;
import java.util.List;
import entidades.Copia;
/**
 *
 * @author Alumno
 */
public class LibroDaoImpEnMemoria implements Dao.LibroDao {

    private static final List<Libro> listaLibros = new ArrayList<>();

    public LibroDaoImpEnMemoria() {
    }

    @Override
    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    @Override
    public Libro obtenerLibroPorTitulo(String nombreLibro) {
        Libro buscado = null;
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equals(nombreLibro)) {
                buscado = libro;
                break;
            }
        }
        return buscado;
    }
    public void agregarCopias(Copia copia, Libro libro){
        for (Libro libroL : listaLibros) {
            if (libroL.equals(libro)) {
                libroL.agregarCopia(copia);
            }
        }
    }
    
    @Override
    public void guardarLibro(Libro l) {
        listaLibros.add(l);
    }

    @Override
    public void eliminarLibro(Libro l) {
        listaLibros.remove(l);
    }

}

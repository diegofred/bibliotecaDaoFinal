/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import entidades.Autor;
import entidades.Libro;
import java.util.ArrayList;
import java.util.List;
import entidades.Copia;
import entidades.TipoLibro;
import java.util.Iterator;
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
    
    @Override
    public void guardarLibro(Libro l) {
        listaLibros.add(l);
    }

    @Override
    public void eliminarLibro(Libro l) {
        listaLibros.remove(l);
    }

   

    @Override
    public List<Libro> buscarLibrosYAutorTipoLibro(Autor autorSeleccionado, TipoLibro tipoLibroSeleccionado) {
      List<Libro> librosFiltrados = new ArrayList<>();
      Iterator<Libro> iter = listaLibros.iterator();
      while(iter.hasNext()){
          Libro l = iter.next();
          if (l.getAutor().equals(autorSeleccionado)
                  && l.getTipoLibro().equals(tipoLibroSeleccionado)) {
              librosFiltrados.add(l);
          }
      }
      return librosFiltrados;
    }

}

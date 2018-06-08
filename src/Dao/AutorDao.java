/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Autor;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface AutorDao {
    List<Autor> obtenerAutores();
    void guardarAutor(Autor a);
    void eliminarAutor(Autor a);
}

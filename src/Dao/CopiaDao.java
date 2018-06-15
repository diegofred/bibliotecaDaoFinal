/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Copia;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface CopiaDao {
    List<Copia> obtenerCopia();
    void guardarCopia(Copia p);
    void eliminarCopia(Copia p);
    String siguienteIdentificador(Copia p);
}

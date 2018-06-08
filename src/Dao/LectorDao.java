/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.Lector;
import java.util.List;
/**
 *
 * @author Alumno
 */
public interface LectorDao {
    List<Lector> obtenerLectores();
    void guardarLector(Lector p);
    void eliminarLector(Lector p);
}

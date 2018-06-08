/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.Multa;
import java.util.List;
/**
 *
 * @author Alumno
 */
public interface MultaDao {
    List<Multa> obtenerMultas();
    void guardarMulta(Multa p);
    void eliminarMulta(Multa p);
}

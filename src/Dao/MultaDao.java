/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import entidades.Lector;
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
    void actualizarMulta(Multa m);
    List<Multa> obtenerMultasVigentesPorLector(Lector lectorSeleccionado);
}

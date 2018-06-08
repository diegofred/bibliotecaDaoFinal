/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import entidades.Cancelacion;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface CancelacionDao {
    List <Cancelacion> obtenerCancelaciones();
    void guardarCancelacion(Cancelacion c);
    void eliminarCancelacion(Cancelacion c);
}

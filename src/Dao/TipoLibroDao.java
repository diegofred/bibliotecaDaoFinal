/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.TipoLibro;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface TipoLibroDao {

    List<TipoLibro> obtenerTiposLibros();

    void guardarTipoLibro(TipoLibro p);

    void eliminarTipoLibro(TipoLibro p);

    void actualizarTipoLibro(TipoLibro tl);
}

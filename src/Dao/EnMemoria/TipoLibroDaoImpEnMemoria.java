/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;
import Dao.TipoLibroDao;
import entidades.TipoLibro;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alumno
 */
public class TipoLibroDaoImpEnMemoria implements TipoLibroDao{
    
    private static final List <TipoLibro> listaTipoLibro = new ArrayList();
    @Override
    public List<TipoLibro> obtenerLibros() {
        return listaTipoLibro;
    }

    @Override
    public void guardarLibros(TipoLibro p) {
        listaTipoLibro.add(p);
    }

    @Override
    public void eliminarLibros(TipoLibro p) {
        listaTipoLibro.remove(p);
    }
    
}

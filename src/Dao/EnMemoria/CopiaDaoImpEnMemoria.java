/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import entidades.Copia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class CopiaDaoImpEnMemoria implements Dao.CopiaDao{

    public static final List <Copia> listaCopias = new ArrayList();
    
    @Override
    public List<Copia> obtenerLibros() {
        return listaCopias;
    }

    @Override
    public void guardarLibro(Copia p) {
        listaCopias.add(p);
    }

    @Override
    public void eliminarLibro(Copia p) {
        listaCopias.remove(p);
    }
    
}

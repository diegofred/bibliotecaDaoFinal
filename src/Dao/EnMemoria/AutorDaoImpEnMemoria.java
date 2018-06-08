/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import entidades.Autor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class AutorDaoImpEnMemoria implements Dao.AutorDao{

    private static final List <Autor> listaAutores = new ArrayList();
    
    @Override
    public List<Autor> obtenerAutores() {
        return listaAutores;
    }


    @Override
    public void guardarAutor(Autor a) {
       listaAutores.add(a);
    }

    @Override
    public void eliminarAutor(Autor a) {
        listaAutores.remove(a);
    }
    
}

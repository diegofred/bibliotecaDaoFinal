/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import entidades.Pais;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class PaisDaoImpEnMemoria implements Dao.PaisDao{
    private static final List <Pais> listaPaises = new ArrayList();
    @Override
    public List<Pais> obtenerPaises() {
        return listaPaises;
    }

    @Override
    public void guardarPais(Pais p) {
        listaPaises.add(p);
    }

    @Override
    public void eliminarPais(Pais p) {
        listaPaises.remove(p);
    }
    
}

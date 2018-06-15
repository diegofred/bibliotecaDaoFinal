/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import entidades.Lector;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class LectorDaoImpEnMemoria implements Dao.LectorDao{

    private static final List <Lector> listaLectores = new ArrayList();
    
    @Override
    public List<Lector> obtenerLectores() {
        return listaLectores;
    }

    @Override
    public void guardarLector(Lector p) {
        listaLectores.add(p);
    }

    @Override
    public void eliminarLector(Lector p) {
        listaLectores.remove(p);
    }

    @Override
    public Lector obtenerLectorPorDni(int dni) {
        for (Lector lector : listaLectores) {
            if (lector.getDni()== dni) {
                return lector;
            }
        }
        return null;//no lo encontro
    }

    
}

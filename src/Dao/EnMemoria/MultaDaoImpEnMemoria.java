/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import entidades.Multa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class MultaDaoImpEnMemoria implements Dao.MultaDao{

    private static final List <Multa> listaMultas = new ArrayList();
    @Override
    public List<Multa> obtenerMultas() {
        return listaMultas;
    }

    @Override
    public void guardarMulta(Multa p) {
        listaMultas.add(p);
    }

    @Override
    public void eliminarMulta(Multa p) {
         listaMultas.remove(p);
    }


    

    
}

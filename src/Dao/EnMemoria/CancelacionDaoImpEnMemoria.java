package Dao.EnMemoria;


import Dao.CancelacionDao;
import entidades.Cancelacion;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public class CancelacionDaoImpEnMemoria implements Dao.CancelacionDao{

    private static final List <Cancelacion> listaCancelacion = new ArrayList();
    
    @Override
    public List<Cancelacion> obtenerCancelaciones() {
        return listaCancelacion;
    }

    @Override
    public void guardarCancelacion(Cancelacion c) {
        listaCancelacion.add(c);
    }

    @Override
    public void eliminarCancelacion(Cancelacion c) {
       listaCancelacion.remove(c);
    }
    

    
}

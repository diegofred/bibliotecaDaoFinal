/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dao.EnMemoria.*;
import Dao.hibernate.*;


/**
 *
 * @author Diego
 */
public class DaoFactory {

    //private static final String tipoDao = "Memoria";
    private static final String TIPO_DAO = "Hibernate";

    public static Object obtenerDao(String nombre) {

        if (TIPO_DAO.equals("Memoria")) {
            return obtenerDaoMemoria(nombre);
        } else if (TIPO_DAO.equals("Hibernate")) {
            return obtenerDaoHibernate(nombre);
        } else {
            return null;
        }

    }

    public static Object obtenerDaoMemoria(String nombre) {
        
        if (nombre.equals(AutorDao.class.getName())) {
            return new AutorDaoImpEnMemoria();
        }else if (nombre.equals(CancelacionDao.class.getName())) {
            return new CancelacionDaoImpEnMemoria();
        }else if (nombre.equals(CopiaDao.class.getName())) {
                  return new CopiaDaoImpEnMemoria();
        }else if (nombre.equals(LectorDao.class.getName())) {
                  return new LectorDaoImpEnMemoria();
        }else if (nombre.equals(LibroDao.class.getName())) {
                  return new LibroDaoImpEnMemoria();
        }else if (nombre.equals(MultaDao.class.getName())) {
                  return new MultaDaoImpEnMemoria();
        }else if (nombre.equals(PrestamoDao.class.getName())) {
                  return new PrestamoDaoImpEnMemoria();
        }else if (nombre.equals(TipoLibroDao.class.getName())) {
                  return new TipoLibroDaoImpEnMemoria();
        }else{
              return null;
        }
     
    }

    public static Object obtenerDaoHibernate(String nombre) {
        if (nombre.equals(AutorDao.class.getName())) {
            return new AutorDaoImpHibernate();
        }else if (nombre.equals(CancelacionDao.class.getName())) {
            return new CancelacionDaoImpHibernate();
        }else if (nombre.equals(CopiaDao.class.getName())) {
                  return new CopiaDaoImpHibernate();
        }else if (nombre.equals(LectorDao.class.getName())) {
                  return new LectorDaoImplHibernate();
        }else if (nombre.equals(LibroDao.class.getName())) {
                  return new LibroDaoDaoImpHibernate();
        }else if (nombre.equals(MultaDao.class.getName())) {
                  return new MultaDaoImpHibernate();
        }else if (nombre.equals(PrestamoDao.class.getName())) {
                  return new PrestamoDaoImpHibernate();
        }else if (nombre.equals(TipoLibroDao.class.getName())) {
                  return new TipoLibroDaoImpHibernate();
        }else{
              return null;
        }

    }

}

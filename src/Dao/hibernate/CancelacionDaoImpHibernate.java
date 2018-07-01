/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.CancelacionDao;
import entidades.Cancelacion;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class CancelacionDaoImpHibernate extends DaoImpHibernate implements CancelacionDao {

    @Override
    public List<Cancelacion> obtenerCancelaciones() {
        Session session = getSession();
        List<Cancelacion> retorno = session.createQuery("from Cancelacion").list();
        return retorno;
    }

    @Override
    public void guardarCancelacion(Cancelacion c) {
        Session session = getSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        
    }

    @Override
    public void eliminarCancelacion(Cancelacion c) {
         Session session = getSession();
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
        
    }

    @Override
    public void actualizarCancelacion(Cancelacion c) {
        Session session = getSession();
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
    }

}

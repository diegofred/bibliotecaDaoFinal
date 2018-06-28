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
        Session session = sessionFactory.openSession();
        List<Cancelacion> retorno = session.createQuery("from cancelacion").list();
        session.close();
        return retorno;
    }

    @Override
    public void guardarCancelacion(Cancelacion c) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarCancelacion(Cancelacion c) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
        session.close();
    }

}

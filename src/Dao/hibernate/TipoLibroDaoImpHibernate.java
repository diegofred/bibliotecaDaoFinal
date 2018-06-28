/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.TipoLibroDao;
import entidades.TipoLibro;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class TipoLibroDaoImpHibernate extends DaoImpHibernate implements TipoLibroDao{

    @Override
    public List<TipoLibro> obtenerTiposLibros() {
        Session session = sessionFactory.openSession();
        List<TipoLibro> retorno = session.createQuery("from tipo_libro").list();
        session.close();
        return retorno;
    }

    @Override
    public void guardarTipoLibro(TipoLibro p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarTipoLibro(TipoLibro p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }
    
}

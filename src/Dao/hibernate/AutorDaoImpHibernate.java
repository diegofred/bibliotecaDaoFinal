/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.AutorDao;
import entidades.Autor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class AutorDaoImpHibernate extends  DaoImpHibernate implements AutorDao{
    
    
    @Override
    public List<Autor> obtenerAutores() {
        Session session = sessionFactory.openSession();
        List<Autor> retorno = session.createQuery("from autor").list();
        session.close();
        return retorno;
    }

    @Override
    public void guardarAutor(Autor a) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarAutor(Autor a) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }
    
}

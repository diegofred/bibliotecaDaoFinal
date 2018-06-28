/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.LectorDao;
import entidades.Lector;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class LectorDaoImplHibernate extends DaoImpHibernate implements LectorDao {

    @Override
    public List<Lector> obtenerLectores() {
        Session session = sessionFactory.openSession();
        List<Lector> retorno = session.createQuery("from lector").list();
        session.close();
        return retorno;
    }

    @Override
    public void guardarLector(Lector p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarLector(Lector p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Lector obtenerLectorPorDni(int dni) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Lector> query = builder.createQuery(Lector.class);
        Root<Lector> root = query.from(Lector.class);
        query.select(root);
        query.where(builder.equal(root.get("dni"), dni));

        Lector lector = session.createQuery(query).uniqueResult();

        session.close();

        return lector;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.MultaDao;
import entidades.Lector;
import entidades.Multa;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class MultaDaoImpHibernate extends DaoImpHibernate implements MultaDao {

    @Override
    public List<Multa> obtenerMultas() {
        Session session = sessionFactory.openSession();
        List<Multa> retorno = session.createQuery("from multa").list();
        session.close();
        return retorno;
    }

    @Override
    public void guardarMulta(Multa p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarMulta(Multa p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Multa> obtenerMultasVigentesPorLector(Lector lectorSeleccionado) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Multa> query = builder.createQuery(Multa.class);
        Root<Multa> root = query.from(Multa.class);
        query.select(root);
        query.where(builder.equal(root.get("lecto_id"), lectorSeleccionado.getId()));

        List<Multa> multas = session.createQuery(query).list();

        session.close();

        return multas;
    }

}

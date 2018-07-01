/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.CopiaDao;
import entidades.Copia;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Diego
 */
public class CopiaDaoImpHibernate extends DaoImpHibernate implements CopiaDao {

    @Override
    public List<Copia> obtenerCopia() {
        Session session = getSession();
        List<Copia> retorno = session.createQuery("from Copia").list();

        return retorno;
    }

    @Override
    public void guardarCopia(Copia p) {
        Session session = getSession();;
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();

    }

    @Override
    public void eliminarCopia(Copia p) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();

    }

    @Override
    public String siguienteIdentificador(Copia p) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery2 = builder.createQuery(Long.class);
        Root<Copia> root2 = criteriaQuery2.from(Copia.class);
        criteriaQuery2.select(builder.max(root2.get("id")));
        Query<Long> query2 = session.createQuery(criteriaQuery2);
        long max_id = (query2.getSingleResult() == null) ? 0L : query2.getSingleResult();
        long siguiente_id = max_id++;
        String codigoDeTipo = p.getLibro().getTipoLibro().getCodigo();
        String identificador = codigoDeTipo + "-" + siguiente_id;
        return identificador;
    }

    @Override
    public void actualizarCopia(Copia c) {
        Session session = getSession();
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
    }

}

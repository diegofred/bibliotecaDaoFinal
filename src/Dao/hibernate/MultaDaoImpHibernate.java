/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.MultaDao;
import entidades.Lector;
import entidades.Multa;
import entidades.Prestamo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class MultaDaoImpHibernate extends DaoImpHibernate implements MultaDao {

    @Override
    public List<Multa> obtenerMultas() {
        Session session = getSession();
        List<Multa> retorno = session.createQuery("from Multa").list();
        return retorno;
    }

    @Override
    public void guardarMulta(Multa p) {
        Session session = getSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
    }

    @Override
    public void eliminarMulta(Multa p) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
    }

    @Override
    public List<Multa> obtenerMultasVigentesPorLector(Lector lectorSeleccionado) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Multa> query = builder.createQuery(Multa.class);
        Root<Multa> root = query.from(Multa.class);
        Join<Multa,Prestamo> prestamo = root.join("prestamo",JoinType.INNER);
       
        
        query.select(root).where(builder.equal(prestamo.get("lector"), lectorSeleccionado));
      
        List<Multa> todasLasMulasDelLector = session.createQuery(query).list();
        List<Multa> multasVigentes  = new ArrayList<>();
        for (Multa m: todasLasMulasDelLector) {
            if (m.estaVigente()) {
                 multasVigentes.add(m);
            }
        }
        return multasVigentes;
    }

    @Override
    public void actualizarMulta(Multa m) {
         Session session = getSession();
        session.beginTransaction();
        session.update(m);
        session.getTransaction().commit();
    }

}

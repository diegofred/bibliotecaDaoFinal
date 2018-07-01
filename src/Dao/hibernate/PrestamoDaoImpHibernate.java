/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.PrestamoDao;
import entidades.Prestamo;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class PrestamoDaoImpHibernate  extends  DaoImpHibernate implements PrestamoDao{

    @Override
    public List<Prestamo> obtenerPrestamos() {
         Session session = getSession();
        List<Prestamo> retorno = session.createQuery("from Prestamo").list();
        
        return retorno;
    }

    @Override
    public void guardarPrestamo(Prestamo p) {
          Session session = getSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        
    }

    @Override
    public void eliminarPrestamo(Prestamo p) {
          Session session = getSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        
    }

    @Override
    public List<Prestamo> obtenerPrestamosNoDevueltos() {
         Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Prestamo> query = builder.createQuery(Prestamo.class);
        Root<Prestamo> root = query.from(Prestamo.class);
        query.select(root);
        query.where(builder.isNull(root.get("fechaDevolucion")));

        List<Prestamo> prestamos = session.createQuery(query).list();

        

        return prestamos;
    }

    @Override
    public void actualizarPrestamo(Prestamo p) {
        Session session = getSession();
        session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
    }
    
}

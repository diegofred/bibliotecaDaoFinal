/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.LibroDao;
import entidades.Autor;
import entidades.Lector;
import entidades.Libro;
import entidades.TipoLibro;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author Diego
 */
public class LibroDaoDaoImpHibernate extends DaoImpHibernate implements LibroDao {

    @Override
    public List<Libro> obtenerLibros() {
        Session session = sessionFactory.openSession();
        List<Libro> retorno = session.createQuery("from libro").list();
        session.close();
        return retorno;
    }

    @Override
    public Libro obtenerLibroPorTitulo(String nombreLibro) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Libro> query = builder.createQuery(Libro.class);
        Root<Libro> root = query.from(Libro.class);
        query.select(root);
        query.where(builder.equal(root.get("titulo"), nombreLibro));
        Libro libro = session.createQuery(query).uniqueResult();
        session.close();
        return libro;
    }

    @Override
    public void guardarLibro(Libro p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarLibro(Libro p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Libro> buscarLibrosYAutorTipoLibro(Autor autorSeleccionado, TipoLibro tipoLibroSeleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

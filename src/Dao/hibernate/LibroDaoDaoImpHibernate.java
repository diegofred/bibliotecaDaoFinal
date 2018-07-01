/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import Dao.LibroDao;
import entidades.Autor;
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
        Session session = getSession();
        List<Libro> retorno = session.createQuery("from Libro").list();

        return retorno;
    }

    @Override
    public Libro obtenerLibroPorTitulo(String nombreLibro) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Libro> query = builder.createQuery(Libro.class);
        Root<Libro> root = query.from(Libro.class);
        query.select(root);
        query.where(builder.equal(root.get("titulo"), nombreLibro));
        Libro libro = session.createQuery(query).uniqueResult();

        return libro;
    }

    @Override
    public void guardarLibro(Libro p) {
        Session session = getSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();

    }

    @Override
    public void eliminarLibro(Libro p) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();

    }

    @Override
    public List<Libro> buscarLibrosYAutorTipoLibro(Autor autorSeleccionado, TipoLibro tipoLibroSeleccionado) {

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Libro> query = builder.createQuery(Libro.class);
        Root<Libro> root = query.from(Libro.class);
        query.select(root)
                .where(
                        builder.and(
                                builder.equal(root.get("autor"), autorSeleccionado))
                                ,builder.equal(root.get("tipoLibro"), tipoLibroSeleccionado));

        List<Libro> librosFiltrados = session.createQuery(query).getResultList();

        return librosFiltrados;
    }

    @Override
    public void actualizarLibro(Libro p) {
        Session session = getSession();
        session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
    }

}

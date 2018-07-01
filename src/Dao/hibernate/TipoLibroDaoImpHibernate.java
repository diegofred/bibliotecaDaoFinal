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
          Session session = getSession();
        List<TipoLibro> retorno = session.createQuery("from TipoLibro").list();
        
        return retorno;
    }

    @Override
    public void guardarTipoLibro(TipoLibro p) {
         Session session = getSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        
    }

    @Override
    public void eliminarTipoLibro(TipoLibro p) {
          Session session = getSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        
    }

    @Override
    public void actualizarTipoLibro(TipoLibro tl) {
        Session session = getSession();
        session.beginTransaction();
        session.update(tl);
        session.getTransaction().commit();
    }
    
}

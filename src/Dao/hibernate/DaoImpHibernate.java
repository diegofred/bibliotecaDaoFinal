/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import org.hibernate.SessionFactory;

/**
 *
 * @author Diego
 */
public class DaoImpHibernate{
   protected SessionFactory sessionFactory;

   public DaoImpHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
   }
   public DaoImpHibernate() {
        this.sessionFactory = ConfiguracionHibernate.getSessionFactory();
   }
}

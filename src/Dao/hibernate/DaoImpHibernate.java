/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Diego
 */
public class DaoImpHibernate{

   private Session session;
 
   public DaoImpHibernate() {
    
   }
   public Session getSession(){
      return ConfiguracionHibernate.getSession();
   }
}

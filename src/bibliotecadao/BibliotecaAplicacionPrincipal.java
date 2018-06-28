/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecadao;

import Control.MenuPrincipalControlador;
import Dao.hibernate.ConfiguracionHibernate;

/**
 *
 * @author Docente
 */
public class BibliotecaAplicacionPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CargaInicial.cargarDatosIniciales();
       ConfiguracionHibernate.getSessionFactory();
       MenuPrincipalControlador mpc = new MenuPrincipalControlador();
       mpc.iniciar();
    }
    
}

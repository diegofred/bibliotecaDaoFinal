/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaces.MenuPrincipal;

/**
 *
 * @author Docente
 */
public class MenuPrincipalControlador {
    
    MenuPrincipal pantallaMenuPrincipal;
    
    public void iniciar(){
        System.out.println("Iniciar En menu prin contro");
        pantallaMenuPrincipal = new MenuPrincipal(this);
        pantallaMenuPrincipal.setVisible(true);
    }

    public void opcionRegistrarLector() {
        RegistrarLector rl = new RegistrarLector();
        rl.iniciar();
    }
    public void opcionABMAutor() {
        GestorAutor rl = new GestorAutor();
        rl.iniciar();
    }

    public void opcionRegistrarPrestamos() {
      GestorPrestamo gp = new GestorPrestamo();
      gp.iniciar();
    }
    
    public void opcionDevolver(){
        GestorDevolverPrestamo gvp = new GestorDevolverPrestamo();
        gvp.iniciar();
    
    }
    
    
    
    
    
}

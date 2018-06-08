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
        pantallaMenuPrincipal = new MenuPrincipal();
        pantallaMenuPrincipal.setVisible(true);
    }
    
    
    
    
    
}

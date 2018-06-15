/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaces.MenuPrincipal;
import Interfaces.RegistrarCopias.TablaCopias;

/**
 *
 * @author Docente
 */
public class MenuPrincipalControlador {
    
    MenuPrincipal pantallaMenuPrincipal;
    
    public void iniciar(){
        pantallaMenuPrincipal = new MenuPrincipal(this);
        pantallaMenuPrincipal.setVisible(true);
    }

    public void opcionRegistrarLector() {
        RegistrarLector rl = new RegistrarLector();
        rl.iniciar();
        
    }

    public void opcionRegistrarPrestamos() {
      GestorPrestamo gp = new GestorPrestamo();
      gp.iniciar();
    }
    
    public void tablaCopia(){
        GestorABMCopia tc = new GestorABMCopia();
        tc.iniciar();
    }
    public void opcionRegistrarTipoLibro() {
        RegistrarTipoLibro rtl = new RegistrarTipoLibro();
        rtl.iniciar();
    }    
    public void opcionDevolver(){
        GestorDevolverPrestamo gvp = new GestorDevolverPrestamo();
        gvp.iniciar();
    
    }
    
    
    
    
    
}

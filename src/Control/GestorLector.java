/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Dao.*;
import entidades.*;
import Dao.EnMemoria.*;
import Interfaces.TablaPersonas;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorLector {
    private final LectorDao lectorDao;
    
    private TablaPersonas tb;
    
    public GestorLector(){
        this.lectorDao = new LectorDaoImpEnMemoria();
    }   
    public void iniciar(){
        List <Lector> listaLectores = lectorDao.obtenerLectores();
        this.tb = new TablaPersonas(); /* Hay que pasarle la lista de lectores y el propio objeto Dao "this" */
        tb.setVisible(true);
    }
}

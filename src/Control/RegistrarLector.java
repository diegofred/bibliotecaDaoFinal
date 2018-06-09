/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.EnMemoria.LectorDaoImpEnMemoria;
import Dao.LectorDao;
import Interfaces.RegistarLector.AltaLector;
import Interfaces.RegistarLector.TablaLectores;
import entidades.Lector;
import java.util.List;

/**
 *
 * @author Docente
 */
public class RegistrarLector {
    
    AltaLector uiAltaLector;
    TablaLectores uiTablaLectores;
    LectorDao lectorDao;

    public RegistrarLector() {
       lectorDao = new LectorDaoImpEnMemoria();
    }
    
    public void iniciar(){
        //Levantar pantalla con la tabla 
        //Buscar los datos para su tabla
        List<Lector> lectores = lectorDao.obtenerLectores();
        uiTablaLectores = new TablaLectores(this, lectores);
        uiTablaLectores.refrescarTabla();
        uiTablaLectores.setVisible(true);
        
    }

    public void opcionAltaLector() {
        uiAltaLector = new AltaLector(this);
        uiAltaLector.setVisible(true);
    }

    public Lector buscarLectorPorDni(String dni) {
        return lectorDao.obtenerLectorPorDni(Integer.parseInt(dni));//no lo encontro
    }

    public void guardarLector(Lector nuevoLector) {
     //Guardo el lector
     lectorDao.guardarLector(nuevoLector);
     
     //Actualizo la tabla
     List<Lector> lectores_actualizados = lectorDao.obtenerLectores();
     uiTablaLectores.setLectores(lectores_actualizados);
     uiTablaLectores.refrescarTabla();
     
     uiAltaLector.dispose();
        
        
    }
    
    
    
}

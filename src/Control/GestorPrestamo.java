/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Dao.*;
import entidades.*;
import Dao.EnMemoria.*;
import Interfaces.TablaPrestamos;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorPrestamo {
    private final LibroDao libroDao;
    private final PrestamoDao prestamoDao;
    private final CopiaDao copiaDao;
    
    private TablaPrestamos tp;
    
    public GestorPrestamo(){
        this.libroDao = new LibroDaoImpEnMemoria();
        this.prestamoDao = new PrestamoDaoImpEnMemoria();
        this.copiaDao = new CopiaDaoImpEnMemoria();
    }
    
    public void iniciar(){
        List<Prestamo> prestamos = prestamoDao.obtenerPrestamos();
        tp = new TablaPrestamos(prestamos,this);
        tp.setVisible(true);
    }
    
}

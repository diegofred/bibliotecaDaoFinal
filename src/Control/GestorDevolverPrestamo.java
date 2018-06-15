/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Dao.*;
import entidades.*;
import Interfaces.DevolucionPrestamos.AltaDevolucionPrestamo;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Alumno
 */
public class GestorDevolverPrestamo {
    
    private final  CopiaDao copiaDao;
    private final PrestamoDao prestamoDao;
    private final LectorDao lectoresDao;
    private final MultaDao daoMulta;
    
    private AltaDevolucionPrestamo dp;
    public GestorDevolverPrestamo(){
        this.copiaDao = new Dao.EnMemoria.CopiaDaoImpEnMemoria();
        this.lectoresDao = new Dao.EnMemoria.LectorDaoImpEnMemoria();
        this.prestamoDao = new Dao.EnMemoria.PrestamoDaoImpEnMemoria();
        this.daoMulta = new Dao.EnMemoria.MultaDaoImpEnMemoria();
    }
    public void iniciar(){
        List <Prestamo> prestamosNoDevueltos = this.prestamoDao.obtenerPrestamosNoDevueltos();
        if (prestamosNoDevueltos.size() == 0) {
            JOptionPane.showMessageDialog(null,"No existen prestamos registrados actualmente");
        }else{
        prestamosNoDevueltos.get(0);
        dp = new AltaDevolucionPrestamo(prestamosNoDevueltos, this);
        dp.setVisible(true);
        }
    }
    public void devolverPrestamo(Prestamo prestamo){
        prestamo.devolverPrestamo();
       
        if (prestamo.correspondeMulta()) {
            Multa nuevaMulta = new Multa();
            nuevaMulta.setPrestamo(prestamo);
            nuevaMulta.setFecha(prestamo.getFechaDevolucion());
            long fd = prestamo.getFechaDevolucion().getTime();
            long fde = prestamo.getFechaPrestamo().getTime() + 30 * (1000*60*60*24);
            nuevaMulta.setCantidadDias((int) ((fd - fde) * 2 ) / (1000*60*60*24) );
            this.daoMulta.guardarMulta(nuevaMulta);
            JOptionPane.showMessageDialog(null,"Se registro una multa");
        }else{
            JOptionPane.showMessageDialog(null,"Se devolvio con exito");
        }
        this.dp.dispose();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.*;
import entidades.*;
import Dao.EnMemoria.*;
import Interfaces.GestionarPrestamo.AltaPrestamo;
import Interfaces.GestionarPrestamo.TablaPrestamos;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorPrestamo {
    private final LibroDao libroDao;

    private final PrestamoDao prestamoDao;
    //   private final CopiaDao copiaDao;
    private final AutorDao autorDao;
    private final TipoLibroDao tipoLibroDao;
    private final LectorDao lectorDao;
    private final MultaDao multaDao;
    
    //Pantallas
    private TablaPrestamos tp;
    private AltaPrestamo ap;

    public GestorPrestamo() {
        this.libroDao = new LibroDaoImpEnMemoria();
        this.prestamoDao = new PrestamoDaoImpEnMemoria();
        //    this.copiaDao = new CopiaDaoImpEnMemoria();
        this.autorDao = new AutorDaoImpEnMemoria();
        this.tipoLibroDao = new TipoLibroDaoImpEnMemoria();
        this.lectorDao = new LectorDaoImpEnMemoria();
        this.multaDao = new MultaDaoImpEnMemoria();
    }

    public void iniciar() {
        List<Prestamo> prestamos = prestamoDao.obtenerPrestamos();
        tp = new TablaPrestamos(prestamos, this);
        tp.setVisible(true);
    }

    public void opcion_alta_prestamo() {
       List<Autor> autores = autorDao.obtenerAutores();
       List<TipoLibro> tiposDeLibros = tipoLibroDao.obtenerTiposLibros();
       List<Lector> lectores = lectorDao.obtenerLectores();
       ap = new AltaPrestamo(autores,tiposDeLibros,lectores,this/*Vinculo con el control*/);
       ap.setVisible(true);
    }

    public List<Libro> buscarLibrosYAutorTipoLibro(Autor autorSeleccionado, TipoLibro tipoLibroSeleccionado) {
       List<Libro> librosFiltrados = libroDao.buscarLibrosYAutorTipoLibro(autorSeleccionado,tipoLibroSeleccionado) ;
       return librosFiltrados;
    }

    public  List<Multa> obtenerMultasVigentesPorLector(Lector lectorSeleccionado) {
       List<Multa> multasVigentes = multaDao.obtenerMultasVigentesPorLector( lectorSeleccionado);
       return multasVigentes;
    }

    public void registrarPrestamo(Prestamo p) {
       prestamoDao.guardarPrestamo(p);
       ap.dispose();
       List<Prestamo> prestamos = prestamoDao.obtenerPrestamos();
       tp.setPrestamos(prestamos);
       tp.refrescarTabla();
    }

}

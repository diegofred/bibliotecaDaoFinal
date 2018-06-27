/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.EnMemoria.*;
import Dao.*;
import entidades.*;
import Interfaces.RegistroLibro.AltaLibros;
import Interfaces.RegistroLibro.TablaLibros;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorLibro {

    private final LibroDao libroDao;
    private final AutorDao autorDao;
    private final TipoLibroDao tipoLibroDao;         
    
    private TablaLibros uiTablaLibros;
    private AltaLibros uiAltaLibros;
    
    public GestorLibro() {
        this.libroDao = new LibroDaoImpEnMemoria();
        this.autorDao = new AutorDaoImpEnMemoria();
        this.tipoLibroDao = new TipoLibroDaoImpEnMemoria();
    }

    public void iniciar() {
        List<Libro> listaLibros = libroDao.obtenerLibros();
        uiTablaLibros = new TablaLibros(this, listaLibros);
        uiTablaLibros.refrescarTabla();
        uiTablaLibros.setVisible(true);
    }
    
    public void opcionAltaLibros() {
        System.out.println("Opcion alta");
        List<Autor> autores = autorDao.obtenerAutores();
        List<TipoLibro> tiposDeLibros = tipoLibroDao.obtenerTiposLibros();
        uiAltaLibros = new AltaLibros(autores, tiposDeLibros,this);
        uiAltaLibros.setVisible(true);
    }
    
    public void guardarLibro(Libro nuevoLibro){
    
        libroDao.guardarLibro(nuevoLibro);
        List<Libro> librosActualizados = libroDao.obtenerLibros();
        uiTablaLibros.setLibros(librosActualizados);
        uiTablaLibros.refrescarTabla();
        uiAltaLibros.dispose();
        
    }

}

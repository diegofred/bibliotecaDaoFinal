/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.CopiaDao;
import Dao.EnMemoria.CopiaDaoImpEnMemoria;
import Dao.EnMemoria.LibroDaoImpEnMemoria;
import Dao.LibroDao;
import Interfaces.RegistrarCopias.TablaCopias;
import entidades.Copia;
import java.util.List;
import Interfaces.RegistrarCopias.AltaCopias;
import entidades.Libro;
/**
 *
 * @author leandro
 */
public class GestorABMCopia {
    private final CopiaDao copiaDao;
    private final LibroDao libroDao;
    //creamos la variable de la Interfaz TablaCopias
    private TablaCopias tc;

    public GestorABMCopia() {
        this.copiaDao = new CopiaDaoImpEnMemoria();
        this.libroDao = new LibroDaoImpEnMemoria();
    }
    
    public void iniciar(){
        List <Copia> copias = copiaDao.obtenerCopia();
        tc = new TablaCopias(this,copias);
        tc.refrescarTabla();
        tc.setVisible(true);
        
    }

    //creamos la Alta Copia
    AltaCopias ac ;
    
    public void agregarCopia() {
        List<Libro> libros = libroDao.obtenerLibros();
        
        ac = new AltaCopias(libros, this);
        ac.setVisible(true);
    }
    public void guardarCopia (Libro l , int i){
        for (int j = 0; j < i; j++) {
        Copia c = new Copia();
        c.setEstado(Copia.EN_BIBLIOTECA);
        c.setLibro(l);
        c.setIdentificador(copiaDao.siguienteIdentificador(c));
        l.getCopias().add(c);
        copiaDao.guardarCopia(c);
        }
        ac.dispose();
        List<Copia> copias = copiaDao.obtenerCopia();
        tc.setCopias(copias);
        tc.refrescarTabla();
    }
    
    
}

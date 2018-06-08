/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Date;
import Dao.*;
import Dao.EnMemoria.*;
import Control.GestorPrestamo;

/**
 *
 * @author Docente
 */
public class LoteDePrueba {
    static  {
        //
        AutorDao autorDao = new AutorDaoImpEnMemoria();
        TipoLibroDao  tipoLibroDao = new TipoLibroDaoImpEnMemoria();
        LibroDao libroDao = new LibroDaoImpEnMemoria();
        CopiaDao copiaDao = new CopiaDaoImpEnMemoria();
        LectorDao lectorDao = new LectorDaoImpEnMemoria();
        PrestamoDao prestamoDao = new PrestamoDaoImpEnMemoria();
        
        
        //AUTORES
        Autor a1 = new Autor();
        a1.setNacionalidad("Española");
        a1.setFechaNacimiento(new Date(50,5,20));
        a1.setNombre("Autor 1");
        autorDao.guardarAutor(a1); 

        Autor a2 = new Autor();
        a2.setNacionalidad("Argentina");
        a2.setFechaNacimiento(new Date(50,5,20));
        a2.setNombre("Autor 2");
        autorDao.guardarAutor(a2); 
          
        Autor a3 = new Autor();
        a3.setNacionalidad("Española");
        a3.setFechaNacimiento(new Date(50,5,20));
        a3.setNombre("Autor 3");
        autorDao.guardarAutor(a3);
     
        //TIPOS DE LIBRO
        TipoLibro tp1 = new TipoLibro();
        tp1.setNombre("Novela");
        tipoLibroDao.guardarLibros(tp1);
        
        TipoLibro tp2 = new TipoLibro();
        tp2.setNombre("Teatro");
        tipoLibroDao.guardarLibros(tp2);
        

        
        
        
        //LIBROS
        Libro l1 = new Libro();
        l1.setTitulo("Libro 1");
        l1.setEditorial("Editorial X");
        l1.setTipoLibro(tp1);
        l1.setAutor(a1);
        libroDao.guardarLibro(l1);
        
        Libro l2 = new Libro();
        l2.setTitulo("Libro 2");
        l2.setEditorial("Editorial Y");
        l2.setTipoLibro(tp1);
        l2.setAutor(a2);
        libroDao.guardarLibro(l2);
        
        
        Libro l3 = new Libro();
        l3.setTitulo("Libro 3");
        l3.setEditorial("Editorial Z");
        l3.setTipoLibro(tp2);
        l3.setAutor(a3);
        libroDao.guardarLibro(l3);
        
        
        //COPIAS
        Copia c1 = new Copia();
        c1.setIdentificador(001);
        c1.setEstado(Copia.PRESTADO);
        c1.setLibro(l1);
        libroDao.agregarCopias(c1, l1);
        
        Copia c2 = new Copia();
        c2.setIdentificador(002);
        c2.setEstado(Copia.EN_BIBLIOTECA);
        c2.setLibro(l2);
        libroDao.agregarCopias(c2, l2);
        
        Copia c3 = new Copia();
        c3.setIdentificador(001);
        c3.setEstado(Copia.EN_REPARACION);
        c3.setLibro(l3);
        libroDao.agregarCopias(c3, l3);
        
        Copia c4 = new Copia();
        c4.setIdentificador(002);
        c4.setEstado(Copia.PRESTADO);
        c4.setLibro(l3);
        libroDao.agregarCopias(c4, l3);
        
        //Lectores
        
        Lector lectorUno = new Lector();
        lectorUno.setApellido("Navarro");
        lectorUno.setNombre("Lautaro");
        
        lectorDao.guardarLector(lectorUno);
        
        //Prestamo
        Prestamo prestamoUno = new Prestamo();
        prestamoUno.setCopia(c4);
        prestamoUno.setLector(lectorUno);
        prestamoDao.guardarPrestamo(prestamoUno);
//            private Date fechaPrestamo;
//            private Date fechaDevolucion;
//            private Copia copia;
//            private Lector lector;

    }
    public static void main(String[] args) {
        GestorPrestamo gestorPrestamo = new GestorPrestamo();
        gestorPrestamo.iniciar();
        
    }
    
}

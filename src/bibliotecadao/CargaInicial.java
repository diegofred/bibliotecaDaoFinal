/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecadao;

import Dao.AutorDao;
import Dao.CopiaDao;
import Dao.LectorDao;
import Dao.LibroDao;
import Dao.MultaDao;
import Dao.PrestamoDao;
import Dao.TipoLibroDao;
import entidades.Autor;
import entidades.Copia;
import entidades.Lector;
import entidades.Libro;
import entidades.Multa;
import entidades.Prestamo;
import entidades.TipoLibro;
import java.util.Date;

/**
 *
 * @author Docente
 */
public class CargaInicial {

    public static void cargarDatosIniciales() {
        AutorDao autorDao = (AutorDao) Dao.DaoFactory.obtenerDao(AutorDao.class.getName());
        TipoLibroDao tipoLibroDao = (TipoLibroDao) Dao.DaoFactory.obtenerDao(TipoLibroDao.class.getName());
        LibroDao libroDao = (LibroDao) Dao.DaoFactory.obtenerDao(LibroDao.class.getName());
        CopiaDao copiaDao = (CopiaDao) Dao.DaoFactory.obtenerDao(CopiaDao.class.getName());
        LectorDao lectorDao = (LectorDao) Dao.DaoFactory.obtenerDao(LectorDao.class.getName());
        PrestamoDao prestamoDao = (PrestamoDao) Dao.DaoFactory.obtenerDao(PrestamoDao.class.getName());
        MultaDao multaDao = (MultaDao) Dao.DaoFactory.obtenerDao(MultaDao.class.getName());

        //AUTORES
        Autor ashakespeare = new Autor();
        ashakespeare.setNacionalidad("Reino Unido");
        ashakespeare.setFechaNacimiento(new Date(-336, 3, 1));
        ashakespeare.setNombre("William Shakespeare");
        autorDao.guardarAutor(ashakespeare);

        Autor aVoltaire = new Autor();
        aVoltaire.setNacionalidad("Francia");
        aVoltaire.setFechaNacimiento(new Date(-206, 10, 21));//21 de noviembre de 1694
        aVoltaire.setNombre("Voltaire");
        autorDao.guardarAutor(aVoltaire);

        Autor acharlesDickens = new Autor();
        acharlesDickens.setNacionalidad("Reino Unido");
        acharlesDickens.setFechaNacimiento(new Date(-88, 1, 7));// 7 de febrero de 1812
        acharlesDickens.setNombre("Charles Dickens");
        autorDao.guardarAutor(acharlesDickens);

        //TIPOS DE LIBRO
        TipoLibro tplNovela = new TipoLibro();
        tplNovela.setNombre("Novela");
        tplNovela.setCodigo("NO");

        TipoLibro tplTeatro = new TipoLibro();
        tplTeatro.setNombre("Teatro");
        tplTeatro.setCodigo("TE");

        TipoLibro tplPoesia = new TipoLibro();
        tplPoesia.setNombre("Poesia");
        tplPoesia.setCodigo("PS");

        TipoLibro tplEnsayo = new TipoLibro();
        tplEnsayo.setNombre("ENSAYO");
        tplEnsayo.setCodigo("EN");

        tipoLibroDao.guardarTipoLibro(tplNovela);
        tipoLibroDao.guardarTipoLibro(tplEnsayo);
        tipoLibroDao.guardarTipoLibro(tplPoesia);
        tipoLibroDao.guardarTipoLibro(tplTeatro);

        //LIBROS
        Libro hamlet = new Libro();
        hamlet.setTitulo("Hamlet");
        hamlet.setEditorial("Sterling Publishing Co Inc");
        hamlet.setTipoLibro(tplTeatro);
        hamlet.setAnio(1609);
        hamlet.setAutor(ashakespeare);
        libroDao.guardarLibro(hamlet);

        Libro ltratadoSobroTolerancia = new Libro();
        ltratadoSobroTolerancia.setTitulo("Tratado sobre la tolerancia");
        ltratadoSobroTolerancia.setEditorial("Editorial Y");
        ltratadoSobroTolerancia.setTipoLibro(tplEnsayo);
        ltratadoSobroTolerancia.setAnio(1762);
        ltratadoSobroTolerancia.setAutor(aVoltaire);
        libroDao.guardarLibro(ltratadoSobroTolerancia);

        Libro libroOliverTwist = new Libro();
        libroOliverTwist.setTitulo("Oliver Twist");
        libroOliverTwist.setEditorial("Editorial Z");
        libroOliverTwist.setAnio(1838);
        libroOliverTwist.setTipoLibro(tplNovela);
        libroOliverTwist.setAutor(acharlesDickens);
        libroDao.guardarLibro(libroOliverTwist);

        //COPIAS
        Copia c1hamlet = new Copia();
        c1hamlet.setEstado(Copia.PRESTADO);
        hamlet.agregarCopia(c1hamlet);
        c1hamlet.setIdentificador(copiaDao.siguienteIdentificador(c1hamlet));
        copiaDao.guardarCopia(c1hamlet);

        Copia c2hamlet = new Copia();
        c2hamlet.setEstado(Copia.EN_BIBLIOTECA);
        hamlet.agregarCopia(c2hamlet);
        c2hamlet.setIdentificador(copiaDao.siguienteIdentificador(c2hamlet));
        copiaDao.guardarCopia(c2hamlet);

        Copia c3hamlet = new Copia();
        c3hamlet.setEstado(Copia.EN_BIBLIOTECA);
        hamlet.agregarCopia(c3hamlet);
        c3hamlet.setIdentificador(copiaDao.siguienteIdentificador(c3hamlet));
        copiaDao.guardarCopia(c3hamlet);
        
        Copia c1tratsobreTol = new Copia();
        c1tratsobreTol.setEstado(Copia.EN_BIBLIOTECA);
        ltratadoSobroTolerancia.agregarCopia(c1tratsobreTol);
        c1tratsobreTol.setIdentificador(copiaDao.siguienteIdentificador(c1tratsobreTol));
        copiaDao.guardarCopia(c1tratsobreTol);
        
        
        Copia c2tratsobreTol = new Copia();
        c2tratsobreTol.setEstado(Copia.EN_BIBLIOTECA);
        ltratadoSobroTolerancia.agregarCopia(c2tratsobreTol);
        c2tratsobreTol.setIdentificador(copiaDao.siguienteIdentificador(c2tratsobreTol));
        copiaDao.guardarCopia(c2tratsobreTol);
 
        Copia c1OliverT = new Copia();
        c1OliverT.setEstado(Copia.EN_BIBLIOTECA);
        libroOliverTwist.agregarCopia(c1OliverT);
        c1OliverT.setIdentificador(copiaDao.siguienteIdentificador(c1OliverT));
        copiaDao.guardarCopia(c1OliverT);

        Copia c2OliverT = new Copia();
        c2OliverT.setEstado(Copia.EN_BIBLIOTECA);
        libroOliverTwist.agregarCopia(c2OliverT);
        
        c2OliverT.setIdentificador(copiaDao.siguienteIdentificador(c2OliverT));
copiaDao.guardarCopia(c2OliverT);
        
 
        //Lectores
        Lector lectorUno = new Lector();
        lectorUno.setApellido("Navarro");
        lectorUno.setNombre("Lautaro");
        lectorUno.setDni(12345678);

        lectorDao.guardarLector(lectorUno);

        //Prestamo
        Prestamo prestamoUno = new Prestamo();
        prestamoUno.setCopia(c1hamlet);
        prestamoUno.setFechaPrestamo(new Date());
        lectorUno.agregarPrestamo(prestamoUno);
        prestamoDao.guardarPrestamo(prestamoUno);

        // PRestamo leandro blanco ==================
        Prestamo prestamoDos = new Prestamo();
        prestamoDos.setFechaPrestamo(new Date(2018 - 1900, 5 - 1, 1));
        prestamoDos.setFechaDevolucion(new Date(2018 - 1900, 5, 15));
        prestamoDos.setCopia(c2OliverT);
        prestamoDos.setLector(lectorUno);
        lectorUno.agregarPrestamo(prestamoDos);
        prestamoDao.guardarPrestamo(prestamoDos);

        // ===============
        Multa multaPrestamoDos = new Multa();
        multaPrestamoDos.setCantidadDias(22);
        multaPrestamoDos.setFecha(new Date(2018 - 1900, 5, 15));
        multaPrestamoDos.setPrestamo(prestamoDos);
        multaDao.guardarMulta(multaPrestamoDos);

    }

    public static void main(String[] args) {
        cargarDatosIniciales();
    }

}

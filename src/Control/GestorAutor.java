/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.AutorDao;
import Dao.EnMemoria.AutorDaoImpEnMemoria;
import Interfaces.RegistroAutor.ListarAutores;
import entidades.Autor;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class GestorAutor {
    private AutorDao aDao;
    private ListarAutores tb;
    public GestorAutor(){
        this.aDao = new AutorDaoImpEnMemoria();
    }
    
    public void iniciar(){
        List <Autor> listaAutores = this.aDao.obtenerAutores();
        this.tb = new ListarAutores(this,listaAutores);
        tb.setVisible(true);
    }
    
}

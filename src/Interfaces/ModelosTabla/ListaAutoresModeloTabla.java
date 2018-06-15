/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.ModelosTabla;

import Control.GestorAutor;
import entidades.Autor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alumno
 */
public class ListaAutoresModeloTabla extends AbstractTableModel{
    
    List <Autor> listaAutores;
    private  String[] COLUMNAS = {"Nombre","Nacionalidad","Fecha de Nacimiento"};
    /*Nombre, nacionalidad, fechanacimiento*/
    public ListaAutoresModeloTabla(List <Autor> listaAutores){
        this.listaAutores = listaAutores;
    }
    
    @Override
    public int getRowCount() {
        return this.listaAutores.size();
    }

    @Override
    public int getColumnCount() {
        return this.COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Object resultado = null;
       Autor autor = listaAutores.get(rowIndex);
       switch(columnIndex){
           case 0:
               resultado = autor.getNombre();
               break;
           case 1:
               resultado = autor.getNacionalidad();
               break;
           case 2:
               resultado = autor.getFechaNacimiento();
               break;
       }
       
       return resultado;
    }

    @Override
    public String getColumnName(int column) {
        return this.COLUMNAS[column];
    }
    
}

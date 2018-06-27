/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.ModelosTabla;

import entidades.Libro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alumno
 */
public class ListaLibrosModeloTabla extends AbstractTableModel{
    
    public static final String[] COLUMNAS = {"Titulo", "Editorial", "Año"};
    
    List<Libro> libros_tabla;

    public ListaLibrosModeloTabla(List<Libro> libros_tabla) {
        this.libros_tabla = libros_tabla;
    }

    @Override
    public int getRowCount() {
        return libros_tabla.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object respuesta = null;
        Libro lb = libros_tabla.get(rowIndex);
        
        switch (columnIndex) {
            case 0://Titulo
                respuesta = lb.getTitulo();
                break;
            case 1://Editorial
                respuesta = lb.getEditorial();
                break;
            case 2://Año
                respuesta = lb.getAnio();
                break;
        }
        
        return respuesta;
    }
    
    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
}

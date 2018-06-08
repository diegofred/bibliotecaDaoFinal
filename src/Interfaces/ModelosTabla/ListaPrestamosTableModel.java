/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.ModelosTabla;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import entidades.*;
/**
 *
 * @author Alumno
 */
public class ListaPrestamosTableModel extends AbstractTableModel{
    
    
    public static final String[] COLUMNAS= {"Nombre","Apellido","Libro","Copia n°"};
    
    List<Prestamo> prestamos;
    
    public ListaPrestamosTableModel(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
    @Override
    public int getRowCount() {
        return prestamos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retorno = null;
        Prestamo p = prestamos.get(rowIndex);
        switch(columnIndex){
            case 0:
            retorno = p.getLector().getNombre();
            break;
            case 1:
            retorno = p.getLector().getApellido();
            break;
            case 2:
            retorno = p.getCopia().getLibro().getTitulo();
            break;
            case 3:
            retorno = p.getCopia().getIdentificador();
            break;
        }
        return retorno;
    }  
    public String getColumnName(int column) {
        return COLUMNAS[column];
    }
    }
    


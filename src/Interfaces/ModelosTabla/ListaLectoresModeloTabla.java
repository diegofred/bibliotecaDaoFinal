/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.ModelosTabla;

import entidades.Lector;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Docente
 */
public class ListaLectoresModeloTabla extends AbstractTableModel{
    public static final String[] COLUMNAS= {"Nombre","Apellido","Dni","n° Lector"};
  
    List<Lector> lectores_tabla ;
    
    
    
    public ListaLectoresModeloTabla(List<Lector> lectores_tabla) {
        this.lectores_tabla = lectores_tabla;
    }

    @Override
    public int getRowCount() {
      return lectores_tabla.size();
    }

    @Override
    public int getColumnCount() {
      return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Object respuesta = null;
      Lector lx =  lectores_tabla.get(rowIndex);
        
      switch (columnIndex) {
            case 0://Nombre
                respuesta = lx.getNombre();
            break;
              case 1://Apellido
                respuesta = lx.getApellido();
            break;
              case 2://DNi
                respuesta = lx.getDni();
            break;
              case 3://Numero Lector
                respuesta = lx.getNumeroLector();
            break;
       }
        
        return respuesta;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column]; //To change body of generated methods, choose Tools | Templates.
    }
 
}

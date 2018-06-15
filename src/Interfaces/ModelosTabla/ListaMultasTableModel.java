/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.ModelosTabla;

/**
 *
 * @author leandro
 */

import entidades.Multa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ListaMultasTableModel extends AbstractTableModel {
 public static final String[] COLUMNAS={"Fecha Prestamo","Lector","Fecha Devolucion", "Libro ","Copia"};
    
    List <Multa> listaMultas;
    
    public ListaMultasTableModel(List<Multa> multas) {
        this.listaMultas = multas;
    }
    @Override
    public int getRowCount() {
      return  listaMultas.size();
    }

    @Override
    public int getColumnCount() {
      return  COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          Object retorno = null;
        Multa m = listaMultas.get(rowIndex);
        switch(columnIndex){
            case 0:
            retorno = m.getPrestamo().getFechaPrestamo();
            break;
            case 1:
            retorno = m.getPrestamo().getLector().toString();
            break;
            case 2:
            retorno = m.getPrestamo().getFechaDevolucion();
            break;
            case 3:
            retorno = m.getPrestamo().getCopia().getLibro();
            break;
            case 4:
            retorno = m.getPrestamo().getCopia().getIdentificador();
            break;
        }
        return retorno;
        
        
        
    }

    @Override
    public String getColumnName(int i) {
        return COLUMNAS[i];
    }
    
    
    
}

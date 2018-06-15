/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.ModelosTabla;

import entidades.Copia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author leandro
 */
public class ListaCopiasTableModel extends AbstractTableModel {

    public static final String[] COLUMNAS={"Libro","Estado","ID"};
    
    List <Copia> listaCopias;
    
    public ListaCopiasTableModel(List<Copia> copias) {
        this.listaCopias = copias;
    }
    @Override
    public int getRowCount() {
      return  listaCopias.size();
    }

    @Override
    public int getColumnCount() {
      return  COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          Object retorno = null;
        Copia p = listaCopias.get(rowIndex);
        switch(columnIndex){
            case 0:
            retorno = p.getLibro().getTitulo();
            break;
            case 1:
            retorno = p.getEstado();
            break;
            case 2:
            retorno = p.getIdentificador();
            break;
        }
        return retorno;
        
        
        
    }

    @Override
    public String getColumnName(int i) {
        return COLUMNAS[i];
    }
    
    
    
}

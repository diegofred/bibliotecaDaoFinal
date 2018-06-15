package Interfaces.ModelosTabla;

import entidades.TipoLibro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ListaTipoLibroModeloTabla extends AbstractTableModel {

    public static final String[] COLUMNAS = {"Nombre", "Codigo", "Cant.Minima"};
    List<TipoLibro> tiposlibros_tabla;

    public ListaTipoLibroModeloTabla(List<TipoLibro> tiposlibros_tabla) {
        this.tiposlibros_tabla = tiposlibros_tabla;
    }

    @Override
    public int getRowCount() {
        return tiposlibros_tabla.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object respuesta = null;
        TipoLibro tiposl = tiposlibros_tabla.get(rowIndex);

        switch (columnIndex) {
            case 0:
                respuesta = tiposl.getNombre();
                break;
            case 1:
                respuesta = tiposl.getCodigo();
                break;
            case 2:
                respuesta = tiposl.getCantidadMinimaLibros();
                break;
        }
        return respuesta;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column]; //To change body of generated methods, choose Tools | Templates.
    }
}

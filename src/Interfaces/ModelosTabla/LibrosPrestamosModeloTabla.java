/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.ModelosTabla;

import entidades.Autor;
import entidades.Libro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Docente
 */
public class LibrosPrestamosModeloTabla extends AbstractTableModel {

    List<Libro> libros;

    private String[] COLUMNAS = {"Titulo", "Copias Disponibles?", "Autor", "Genero", "Editorial"};

    public LibrosPrestamosModeloTabla(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public int getRowCount() {
        return this.libros.size();
    }

    @Override
    public int getColumnCount() {
        return this.COLUMNAS.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado = null;
        Libro l = libros.get(rowIndex);
        switch (columnIndex) {
            case 0:
                resultado = l.getTitulo();
                break;
            case 1:
                resultado = l.copiasDisponibles() > 0 ? "Si" :"No";
                break;
            case 2:
                resultado = l.getAutor().getNombre();
                break;
            case 3:
                resultado = l.getTipoLibro().getNombre();
                break;
            case 4:
                resultado = l.getEditorial();
                break;
        }

        return resultado;
    }

    @Override
    public String getColumnName(int column) {
        return this.COLUMNAS[column];
    }
}

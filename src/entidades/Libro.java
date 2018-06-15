/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import Dao.EnMemoria.CopiaDaoImpEnMemoria;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Libro {
    private String editorial;
    private int anio;
    private String titulo;
    private Autor autor;
    private TipoLibro tipoLibro;
    private ArrayList <Copia> copias = new ArrayList<>();

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public TipoLibro getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(TipoLibro tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public ArrayList<Copia> getCopias() {
        return copias;
    }

    public void setCopias(ArrayList<Copia> copias) {
        this.copias = copias;
    }
    
    public Libro(){
    
    }
    
    public Libro(String editorial, int anio, String titulo, Autor autor, TipoLibro tipolibro, ArrayList copias){
    this.editorial = editorial;
    this.anio = anio;
    this.titulo = titulo;
    this.autor = autor;
    this.tipoLibro = tipolibro;
    this.copias = copias;
    }
    
    public Libro(String editorial, int anio, String titulo, Autor autor, TipoLibro tipolibro){
    this.editorial = editorial;
    this.anio = anio;
    this.titulo = titulo;
    this.autor = autor;
    this.tipoLibro = tipolibro;
    }
    
    public void agregarCopia(Copia copia){
        this.copias.add(copia);
        copia.setLibro(this);
    }
    public void agregarCopias(int cantidad){
        int largo = this.copias.size();
        Copia copia = new Copia();
        for (int i = largo ; i < largo + cantidad ; i++) {
            copia = new Copia(Copia.EN_BIBLIOTECA,this);
            this.agregarCopia(copia);
        }
    }
    
    public int copiasDisponibles(){
        int copiasDisponibles = 0;
        for (Copia copia : copias) {
            if (copia.getEstado().equals(Copia.EN_BIBLIOTECA)) {
                copiasDisponibles++;
            }
        }
        return copiasDisponibles;
    }
    
    public Copia obtenerSiguienteCopiaDisponible(){
        Copia elegida = null;
        for (Copia copia : copias) {
            if (copia.getEstado().equals(Copia.EN_BIBLIOTECA)) {
                elegida = copia;
                break;
            }
        }
        return elegida;
    }
    
    @Override
    public String toString(){
    return this.titulo;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Alumno
 */
public class TipoLibro {
    private long id;
    private String nombre;
    private int cantidadMinimaLibros;
    private String codigo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
 
    
 
    public int getCantidadMinimaLibros() {
        return cantidadMinimaLibros;
    }

    public void setCantidadMinimaLibros(int cantidadMinimaLibros) {
        this.cantidadMinimaLibros = cantidadMinimaLibros;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    public TipoLibro(){
    
    }
    public TipoLibro (String nombre){
        this.nombre = nombre;
    }
    
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    }

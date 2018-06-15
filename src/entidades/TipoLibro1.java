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
public class TipoLibro1 {

    private static int siguienteNumeroLector = 3;

    private String nombre;
    private int cantidadMinimaLibros;
    private int codigo = siguienteNumeroLector++;

    public int getCantidadMinimaLibros() {
        return cantidadMinimaLibros;
    }

    public void setCantidadMinimaLibros(int cantidadMinimaLibros) {
        this.cantidadMinimaLibros = cantidadMinimaLibros;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoLibro1() {

    }

    public TipoLibro1(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

}

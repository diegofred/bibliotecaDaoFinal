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
public class Copia {
    
    public final static String EN_BIBLIOTECA = "En biblioteca";
    public final static String PRESTADO = "Prestado";
    public final static String EN_REPARACION = "En reparacion";
    public final static String EN_RETRASO = "En retraso";
    
    private String identificador;
    private String estado;
    private Libro libro;
    
    public Copia(){
    
    }
    

    public Copia( String estado, Libro libro){
  
        this.estado = estado;
        this.libro = libro;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    
    
    
}

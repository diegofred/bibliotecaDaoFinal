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
public class PrestamoException extends Exception {

    public PrestamoException() {
        super();
    }
    
    @Override
    public String getMessage(){
        return "El usuario tiene una multa, o la copia no esta en la biblioteca";
    }
    
}

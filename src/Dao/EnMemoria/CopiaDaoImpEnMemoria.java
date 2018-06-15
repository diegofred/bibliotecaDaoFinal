/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.EnMemoria;

import entidades.Copia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class CopiaDaoImpEnMemoria implements Dao.CopiaDao{

    private static final List <Copia> listaCopias = new ArrayList();
    private static int siguienteId = 1;
    @Override
    public List<Copia> obtenerCopia() {
        return listaCopias;
    }

    @Override
    public void guardarCopia(Copia p) {
        listaCopias.add(p);
    }

    @Override
    public void eliminarCopia(Copia p) {
        listaCopias.remove(p);
    }

    @Override
    public String siguienteIdentificador(Copia p) {
        String codigoDeTipo= p.getLibro().getTipoLibro().getCodigo();
        String identificador = codigoDeTipo+"-"+siguienteId;
        siguienteId++;
        return identificador;
    }
    
}

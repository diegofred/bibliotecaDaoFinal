/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.DaoFactory;
import Dao.MultaDao;
import Interfaces.RegistrarMultas.TablaMultas;
import entidades.Multa;
import java.util.List;

/**
 *
 * @author leandro
 */
public class GestorMulta {

    private final MultaDao multaDao;

    private TablaMultas tm;

    public GestorMulta() {
        this.multaDao = (MultaDao) DaoFactory.obtenerDao(MultaDao.class.getName());
    }

    public void iniciar() {
        List<Multa> multas = multaDao.obtenerMultas();
        tm = new TablaMultas(this, multas);
        tm.refrescarTabla();
        tm.setVisible(true);

    }

}

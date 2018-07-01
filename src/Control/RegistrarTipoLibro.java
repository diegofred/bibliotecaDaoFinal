/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.DaoFactory;
import Dao.TipoLibroDao;
import Interfaces.RegistrarTipoLibro.AltaTipoLibro;
import Interfaces.RegistrarTipoLibro.TablaTiposLibros;
import entidades.TipoLibro;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class RegistrarTipoLibro {

    AltaTipoLibro uiAltaTipos;
    TablaTiposLibros uiTablaTipos;
    TipoLibroDao tipoLibroDao;

    public RegistrarTipoLibro() {
        this.tipoLibroDao = (TipoLibroDao) DaoFactory.obtenerDao(TipoLibroDao.class.getName());
    }

    public void iniciar() {
        List<TipoLibro> tipos = tipoLibroDao.obtenerTiposLibros();
        uiTablaTipos = new TablaTiposLibros(this, tipos);
        uiTablaTipos.refrescarTabla();
        uiTablaTipos.setVisible(true);
    }

    public void opcionAltaTipoLibro() {
        uiAltaTipos = new AltaTipoLibro(this);
        uiAltaTipos.setVisible(true);
    }

    public void guardarTipoLibro(TipoLibro nueTipoLibro) {
        tipoLibroDao.guardarTipoLibro(nueTipoLibro);

        List<TipoLibro> tiposactualizados = tipoLibroDao.obtenerTiposLibros();
        uiTablaTipos.setTipos(tiposactualizados);
        uiTablaTipos.refrescarTabla();
        uiAltaTipos.dispose();

    }

}

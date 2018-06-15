/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.EnMemoria.TipoLibroDaoImpEnMemoria;
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
    TipoLibroDao tipoDao;

    public RegistrarTipoLibro() {
        tipoDao = new TipoLibroDaoImpEnMemoria();
    }

    public void iniciar() {
        List<TipoLibro> tipos = tipoDao.obtenerTiposLibros();
        uiTablaTipos = new TablaTiposLibros(this, tipos);
        uiTablaTipos.refrescarTabla();
        uiTablaTipos.setVisible(true);
    }

    public void opcionAltaTipoLibro() {
        uiAltaTipos = new AltaTipoLibro(this);
        uiAltaTipos.setVisible(true);
    }

    public void guardarTipoLibro(TipoLibro nueTipoLibro) {
        tipoDao.guardarTipoLibro(nueTipoLibro);

        List<TipoLibro> tiposactualizados = tipoDao.obtenerTiposLibros();
        uiTablaTipos.setTipos(tiposactualizados);
        uiTablaTipos.refrescarTabla();
        uiAltaTipos.dispose();

    }

}

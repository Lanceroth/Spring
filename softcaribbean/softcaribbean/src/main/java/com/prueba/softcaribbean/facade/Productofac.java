package com.prueba.softcaribbean.facade;

import com.prueba.softcaribbean.exception.FacadeException;
import com.prueba.softcaribbean.database.ManagerConexion;
import com.prueba.softcaribbean.dto.Producto;
import com.prueba.softcaribbean.mgr.Productomg;


import java.util.List;

public class Productofac implements ProductofacInterface {

    private Productomg pmg;

    public Productofac() {
        this.pmg = new Productomg();
    }


    public void save(Producto producto) throws FacadeException {
        try {
            ManagerConexion.getInstance().open();
            pmg.save(producto);
            ManagerConexion.getInstance().commit();
        } catch (Exception e) {
            ManagerConexion.getInstance().rollback();
            throw new FacadeException(e);
        } finally {
            ManagerConexion.getInstance().close();
        }

    }

    public void delete(Producto producto) throws FacadeException {

        try {
            pmg.delete(producto);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    public List<Producto> selectAll() throws FacadeException {
        ManagerConexion.getInstance().open();
        try {
            return pmg.selectAll();
        } catch (Exception e) {
            throw new FacadeException(e);

        } finally {
            ManagerConexion.getInstance().close();
        }

    }
}

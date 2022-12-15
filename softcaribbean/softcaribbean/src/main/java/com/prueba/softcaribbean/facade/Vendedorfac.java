package com.prueba.softcaribbean.facade;

import com.prueba.softcaribbean.exception.FacadeException;
import com.prueba.softcaribbean.database.ManagerConexion;
import com.prueba.softcaribbean.dto.Vendedor;
import com.prueba.softcaribbean.mgr.Vendedormg;

import java.util.List;

public class Vendedorfac {

    private Vendedormg vmg;

    public Vendedorfac() {
        this.vmg = new Vendedormg();
    }

    public void save(Vendedor vendedor) throws FacadeException {
        try {
            ManagerConexion.getInstance().open();
            vmg.save(vendedor);
            ManagerConexion.getInstance().commit();
        } catch (Exception e) {
            ManagerConexion.getInstance().rollback();
            throw new FacadeException(e);
        } finally {
            ManagerConexion.getInstance().close();
        }
    }

    public void delete(Vendedor vendedor) throws FacadeException {

        try {
            vmg.delete(vendedor);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    public List<Vendedor> selectAll() throws FacadeException {
        ManagerConexion.getInstance().open();
        try {
            return vmg.selectAll();
        } catch (Exception e) {
            throw new FacadeException(e);
        } finally {
            ManagerConexion.getInstance().close();
        }
    }
}

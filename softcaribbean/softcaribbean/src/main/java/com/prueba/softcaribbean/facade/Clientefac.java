package com.prueba.softcaribbean.facade;

import com.prueba.softcaribbean.database.ManagerConexion;
import com.prueba.softcaribbean.dto.Cliente;
import com.prueba.softcaribbean.exception.FacadeException;
import com.prueba.softcaribbean.mgr.Clientemg;


import java.util.List;

public class Clientefac {
    private Clientemg pmg;

    public Clientefac() {this.pmg = new Clientemg();}

    public void save(Cliente cliente) throws FacadeException {
        try {
            ManagerConexion.getInstance().open();
            pmg.save(cliente);
            ManagerConexion.getInstance().commit();
        } catch (Exception e) {
            ManagerConexion.getInstance().rollback();
            throw new FacadeException(e);
        } finally {
            ManagerConexion.getInstance().close();
        }
    }

    public void delete(Cliente cliente) throws FacadeException {

        try {
            pmg.delete(cliente);
        } catch (Exception e) {
            throw new FacadeException(e);
        }
    }

    public List<Cliente> selectAll() throws FacadeException {
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

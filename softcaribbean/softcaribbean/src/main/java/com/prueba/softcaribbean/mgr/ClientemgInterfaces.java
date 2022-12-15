package com.prueba.softcaribbean.mgr;

import com.prueba.softcaribbean.dto.Cliente;
import com.prueba.softcaribbean.exception.ManagerException;

import java.util.List;

public interface ClientemgInterfaces {
    public interface InterfProdmg {
        public void save(Cliente cliente) throws ManagerException;

        public void delete(Cliente cliente) throws ManagerException;

        public List<Cliente> selectAll() throws ManagerException;
    }
}
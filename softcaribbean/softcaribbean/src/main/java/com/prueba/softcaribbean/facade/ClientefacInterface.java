package com.prueba.softcaribbean.facade;

import com.prueba.softcaribbean.dto.Cliente;

import com.prueba.softcaribbean.exception.FacadeException;

import java.util.List;

public interface ClientefacInterface {
    public void save(Cliente cliente) throws FacadeException;

    public void delete(Cliente cliente) throws FacadeException;

    public List<Cliente> selectAll() throws FacadeException;
}

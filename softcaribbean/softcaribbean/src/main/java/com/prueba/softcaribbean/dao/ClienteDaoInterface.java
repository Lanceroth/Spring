package com.prueba.softcaribbean.dao;

import com.prueba.softcaribbean.dto.Cliente;
import com.prueba.softcaribbean.exception.DaoException;

import java.util.List;

public interface ClienteDaoInterface {
    public void insert(Cliente cliente) throws DaoException;

    public void update(Cliente cliente) throws DaoException;

    public void delete(Cliente cliente) throws DaoException;

    public List<Cliente> selectAll() throws DaoException;
}

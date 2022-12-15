package com.prueba.softcaribbean.dao;


import com.prueba.softcaribbean.dto.Vendedor;
import com.prueba.softcaribbean.exception.DaoException;

import java.util.List;

public interface VendedorDaoInterfaces {
    public void insert(Vendedor vendedor) throws DaoException;

    public void update(Vendedor vendedor) throws DaoException;

    public void delete(Vendedor vendedor) throws DaoException;

    public List<Vendedor> selectAll() throws DaoException;
}

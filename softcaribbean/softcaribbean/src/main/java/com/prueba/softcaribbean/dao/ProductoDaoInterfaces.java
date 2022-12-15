package com.prueba.softcaribbean.dao;

import com.prueba.softcaribbean.exception.DaoException;
import com.prueba.softcaribbean.dto.Producto;


import java.util.List;

public interface ProductoDaoInterfaces {
    public void insert(Producto producto) throws DaoException;

    public void update(Producto producto) throws DaoException;

    public void delete(Producto producto) throws DaoException;

    public List<Producto> selectAll() throws DaoException;
}

package com.prueba.softcaribbean.facade;

import com.prueba.softcaribbean.exception.FacadeException;
import com.prueba.softcaribbean.dto.Producto;


import java.util.List;

public interface ProductofacInterface {
    public void save(Producto p) throws FacadeException;

    public void delete(Producto p) throws FacadeException;

    public List<Producto> selectAll() throws FacadeException;
}

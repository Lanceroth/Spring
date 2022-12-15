package com.prueba.softcaribbean.controller;

import com.prueba.softcaribbean.exception.ExceptionController;
import com.prueba.softcaribbean.dto.Producto;

import java.util.List;

public interface ProdControlInterfaces {
    public void save(Producto dto) throws ExceptionController;
    public void delete(Producto dto) throws ExceptionController;
    public List<Producto> selectAll() throws ExceptionController;
}

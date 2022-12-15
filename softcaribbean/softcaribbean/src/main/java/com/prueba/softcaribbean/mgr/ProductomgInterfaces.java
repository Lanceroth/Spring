package com.prueba.softcaribbean.mgr;

import com.prueba.softcaribbean.exception.ManagerException;
import com.prueba.softcaribbean.dto.Producto;


import java.util.List;

public interface ProductomgInterfaces {
    public void save(Producto producto) throws ManagerException;
    public void delete(Producto producto)throws ManagerException;
    public List<Producto> selectAll() throws ManagerException;

}

package com.prueba.softcaribbean.mgr;


import com.prueba.softcaribbean.dto.Vendedor;
import com.prueba.softcaribbean.exception.ManagerException;

import java.util.List;

public interface VendedormgInterfaces {
    public void save(Vendedor vendedor) throws ManagerException;
    public void delete(Vendedor vendedor)throws ManagerException;
    public List<Vendedor> selectAll() throws ManagerException;
}

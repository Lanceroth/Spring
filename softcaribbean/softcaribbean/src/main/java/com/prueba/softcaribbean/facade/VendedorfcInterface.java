package com.prueba.softcaribbean.facade;


import com.prueba.softcaribbean.dto.Vendedor;
import com.prueba.softcaribbean.exception.FacadeException;

import java.util.List;

public interface VendedorfcInterface {
    public void save(Vendedor vendedor) throws FacadeException;

    public void delete(Vendedor vendedor) throws FacadeException;

    public List<Vendedor> selectAll() throws FacadeException;
}

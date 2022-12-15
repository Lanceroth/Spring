package com.prueba.softcaribbean.mgr;

import com.prueba.softcaribbean.exception.ManagerException;
import com.prueba.softcaribbean.dao.VendedorDao;
import com.prueba.softcaribbean.dto.Vendedor;

import java.util.List;

public class Vendedormg implements VendedormgInterfaces {
    private VendedorDao d;

    public Vendedormg() {this.d = new VendedorDao();}

    public void save(Vendedor vendedor) throws ManagerException {
        try {
            Vendedor v= d.selectbyid(vendedor);
            if(v == null){
                d.insert(vendedor);
            }else {
                d.update(vendedor);
            }
        }catch (Exception e){
            throw new ManagerException(e);

        }
    }

    public void delete(Vendedor vendedor) throws ManagerException{
        try {
            Vendedor v= d.selectbyid(vendedor);
            if(v!=null){
                d.delete(vendedor);
            }
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    public List<Vendedor> selectAll() throws ManagerException{
        try {
            return d.selectAll();
        }catch (Exception e){
            throw new ManagerException();
        }
    }
}

package com.prueba.softcaribbean.mgr;

import com.prueba.softcaribbean.exception.ManagerException;
import com.prueba.softcaribbean.dao.ProductoDao;
import com.prueba.softcaribbean.dto.Producto;


import java.util.List;

public class Productomg implements ProductomgInterfaces {
    private ProductoDao p;

    public Productomg() {this.p = new ProductoDao();}

    public void save(Producto producto) throws ManagerException {

        try {
            Producto tp= p.selectbyid(producto);
            if(tp==null){
                p.insert(producto);
            }else{
                p.update(producto);
            }
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    public void delete(Producto producto)throws ManagerException{
        try {
            Producto tp= p.selectbyid(producto);
            if(tp!=null){
                p.delete(producto);
            }
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    public List<Producto> selectAll() throws ManagerException{
        try {
            return p.selectAll();
        }catch (Exception e){
            throw new ManagerException(e);

        }

    }


}

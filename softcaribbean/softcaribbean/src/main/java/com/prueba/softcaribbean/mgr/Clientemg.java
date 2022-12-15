package com.prueba.softcaribbean.mgr;

import com.prueba.softcaribbean.dao.ClienteDao;
import com.prueba.softcaribbean.dto.Cliente;
import com.prueba.softcaribbean.exception.ManagerException;

import java.util.List;

public class  Clientemg implements ClientemgInterfaces {
    private com.prueba.softcaribbean.dao.ClienteDao c;

    public Clientemg() {this.c = new ClienteDao();}

    public void save(Cliente cliente) throws ManagerException {

        try {
            Cliente tp= c.selectbyid(cliente);
            if(tp==null){
                c.insert(cliente);
            }else{
                c.update(cliente);
            }
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    public void delete(Cliente cliente)throws ManagerException{
        try {
            Cliente tp= c.selectbyid(cliente);
            if(tp!=null){
                c.delete(cliente);
            }
        }catch (Exception e){
            throw new ManagerException(e);
        }
    }

    public List<Cliente> selectAll() throws ManagerException{
        try {
            return c.selectAll();
        }catch (Exception e){
            throw new ManagerException(e);

        }

    }

}

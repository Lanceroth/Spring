package com.prueba.softcaribbean.controller;

import com.prueba.softcaribbean.exception.ExceptionController;
import com.prueba.softcaribbean.dto.Vendedor;
import com.prueba.softcaribbean.facade.Vendedorfac;


public class VenControl {
    private Vendedorfac vf;

    public VenControl(){
        this.vf = new Vendedorfac();
    }

    public void save(Vendedor dto) throws ExceptionController {
        try {
            vf.save(dto);
        }catch (Exception e){
            throw new ExceptionController(e);
        }
    }

    public void  delete(Vendedor dto) throws ExceptionController{
        try {
            vf.delete(dto);
        }catch (Exception e) {
            throw new ExceptionController(e);
        }
    }

    public Vendedor selectAll() throws ExceptionController{
        try {
            vf.selectAll();
        }catch (Exception e){
            throw new ExceptionController(e);
        }
        return null;
    }

}

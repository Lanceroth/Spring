package com.prueba.softcaribbean;

import com.prueba.softcaribbean.controller.ProdControl;
import com.prueba.softcaribbean.dto.Producto;
import com.prueba.softcaribbean.exception.ExceptionController;

public class Main {
    public static void main(String[] args) {

        ProdControl pcon = new ProdControl();
        Producto producto = new Producto();
        producto.setSku("1");
        producto.setDsproducto("queso");

        try {
            pcon.save(producto);
        } catch (ExceptionController e) {
            throw new RuntimeException(e);
        }
    }
}

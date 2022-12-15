package com.prueba.softcaribbean.controller;

import com.prueba.softcaribbean.dto.Mensaje;
import com.prueba.softcaribbean.exception.ExceptionController;
import com.prueba.softcaribbean.dto.Producto;
import com.prueba.softcaribbean.facade.Productofac;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdControl{
    private com.prueba.softcaribbean.facade.Productofac pf;

    public ProdControl() {
        this.pf = new Productofac();
    }


    /*public void save(Producto dto) throws ExceptionController {

        try {
            pf.save(dto);
        }catch (Exception e){
            throw new ExceptionController(e);
        }
    }*/
    @PostMapping("producto/Save")
    public ResponseEntity<Mensaje> save(@RequestBody Producto producto) throws ExceptionController {
        Mensaje mensaje = new Mensaje();
        try {
            pf.save(producto);
            mensaje.setCodigo(0);
            mensaje.setMensaje("Dato Almancenado con exito!!");
        } catch (Exception e) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error: El dato no almaceno");
            throw new ExceptionController(e);

        }
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping("producto/Delete")
    public ResponseEntity<Mensaje> delete(@RequestBody Producto producto) throws ExceptionController {
        Mensaje mensaje = new Mensaje();
        try {
            pf.delete(producto);
            mensaje.setCodigo(0);
            mensaje.setMensaje("Dato Eliminado con exito");
        } catch (Exception e) {
            mensaje.setCodigo(0);
            mensaje.setMensaje("Error: El dato no se elimino");
            throw new ExceptionController(e);

        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("producto/all")
    public ResponseEntity<Mensaje> selectAll() throws ExceptionController {
        Mensaje mensaje = new Mensaje();
        try {
            List<Producto> productos = pf.selectAll();
            mensaje.setCodigo(0);
            mensaje.setData(productos);
        } catch (Exception E) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error: No se muestra los datos");
            throw new ExceptionController(E);

        }
        return ResponseEntity.ok(mensaje);
    }

}

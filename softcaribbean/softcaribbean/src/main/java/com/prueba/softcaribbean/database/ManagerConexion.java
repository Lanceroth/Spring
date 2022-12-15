package com.prueba.softcaribbean.database;

import java.sql.Connection;

public class ManagerConexion {

    private static ManagerConexion instance;
    private Conexion conexion;
    private ManagerConexion(){
        conexion = new Conexion();
    }
    public static ManagerConexion getInstance(){
        if(instance==null){
            instance=new ManagerConexion();
        }
        return instance;
    }

    public void open(){
        conexion.connect();
    }
    public void commit(){
        try{
            conexion.getConn().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void rollback(){
        try{
            conexion.getConn().rollback();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void close(){
        try{
            conexion.getConn().close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public Connection getConnection()
    {
        return conexion.getConn();
    }
}

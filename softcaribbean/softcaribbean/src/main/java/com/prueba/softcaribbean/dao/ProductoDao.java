package com.prueba.softcaribbean.dao;

import com.prueba.softcaribbean.exception.DaoException;
import com.prueba.softcaribbean.database.ManagerConexion;
import com.prueba.softcaribbean.dto.Producto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao implements ProductoDaoInterfaces {
    public void insert(Producto producto) throws DaoException {
        String INSERT = "INSERT INTO productos (sku,dsproducto) VALUES (?,?)";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setString(1, producto.getSku());
            statement.setString(2, producto.getDsproducto());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void update(Producto producto) throws DaoException {
        String UPDATE = "UPDATE  productos SET dsproducto =? WHERE sku =?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, producto.getDsproducto());
            statement.setString(2, producto.getSku());
            statement.executeUpdate();


        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(Producto producto) throws DaoException {
        String DELETE = "DELETE FROM productos WHERE (sku=?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Connection connection = ManagerConexion.getInstance().getConnection();
        try{


        }catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Producto selectbyid(Producto producto) throws DaoException {
        Producto _result = null;
        String SELECT = "SELECT sku,dsproducto\n" +
                "FROM productos\n" +
                "WHERE sku=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //Obtengo la conexión
        Connection connection = ManagerConexion.getInstance().getConnection();
        /*System.out.println(connection);*/
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, producto.getSku());

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                _result = new Producto();
                _result.setSku(resultSet.getString("sku"));
                _result.setDsproducto(resultSet.getString("dsproducto"));
            }


        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return _result;
    }

    public List<Producto> selectAll() throws DaoException {
        List<Producto> lista = new ArrayList<>();
        String SELECT = "SELECT sku,dsproducto FROM productos";


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //Obtengo la conexión
        Connection connection = ManagerConexion.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(SELECT);


            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Producto _result = new Producto();
                _result.setSku(resultSet.getString("sku"));
                _result.setDsproducto(resultSet.getString("dsproducto"));
                lista.add(_result);
            }


        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}

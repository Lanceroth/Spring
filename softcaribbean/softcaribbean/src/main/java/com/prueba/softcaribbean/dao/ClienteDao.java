package com.prueba.softcaribbean.dao;

import com.prueba.softcaribbean.database.ManagerConexion;
import com.prueba.softcaribbean.dto.Cliente;
import com.prueba.softcaribbean.exception.DaoException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    public void insert(Cliente cliente) throws DaoException {
        String INSERT = "INSERT INTO cliente (nmcliente,documento,dsnombres,dsapellidos,dsdireccion) VALUES (?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, cliente.getNmcliente());
            statement.setString(2, cliente.getDocumento());
            statement.setString(3, cliente.getDsnombres());
            statement.setString(4, cliente.getDsapellidos());
            statement.setString(5, cliente.getDsdireccion());
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

    public void update(Cliente cliente) throws DaoException {
        String UPDATE = "UPDATE cliente SET documento=?,dsnombres=?,dsapellidos=?,dsdireccion=? WHERE nmcliente=?";

        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, cliente.getDocumento());
            statement.setString(2, cliente.getDsnombres());
            statement.setString(3, cliente.getDsapellidos());
            statement.setString(4, cliente.getDsdireccion());
            statement.setInt(5, cliente.getNmcliente());
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

    public void delete(Cliente cliente) throws DaoException {
        try {

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Cliente selectbyid(Cliente cliente) throws DaoException {
        Cliente _result = null;
        String SELECT = "SELECT nmcliente,documento,dsnombres,dsapellidos,dsdireccion\n" +
                "FROM cliente\n" +
                "WHERE nmcliente=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        System.out.println(connection);

        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, cliente.getNmcliente());

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                _result = new Cliente();
                _result.setNmcliente(resultSet.getInt("nmcliente"));
                _result.setDocumento(resultSet.getString("documento"));
                _result.setDsnombres(resultSet.getString("dsnombres"));
                _result.setDsapellidos((resultSet.getString("dsapellidos")));
                _result.setDsdireccion(resultSet.getString("dsdireccion"));
            }
            return _result;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Cliente> selectAll() throws DaoException {
        List<Cliente> lista = new ArrayList<>();
        String SELECT = "SELECT nmclient,documento,dsnombres,dsapellidos,dsdireccion FROM cliente";


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //Obtengo la conexión
        Connection connection = ManagerConexion.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(SELECT);


            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente _result = new Cliente();
                _result.setNmcliente(resultSet.getInt("nmcliente"));
                _result.setDocumento(resultSet.getString("documento"));
                _result.setDsnombres(resultSet.getString("dsnombres"));
                _result.setDsapellidos(resultSet.getString("dsapellidos"));
                _result.setDsdireccion(resultSet.getString("dsdireccion"));
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

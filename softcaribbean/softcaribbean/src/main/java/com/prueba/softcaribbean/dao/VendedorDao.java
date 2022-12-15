package com.prueba.softcaribbean.dao;


import com.prueba.softcaribbean.exception.DaoException;
import com.prueba.softcaribbean.database.ManagerConexion;
import com.prueba.softcaribbean.dto.Vendedor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao {
    public void insert(Vendedor vendedor) throws DaoException {
        String INSERT = "INSERT INTO vendedor (nmvendedor,documento,dsnombres,dsapellidos,dsdireccion) VALUES (?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(INSERT);
            statement.setInt(1, vendedor.getNmvendedor());
            statement.setString(2, vendedor.getDocumento());
            statement.setString(3, vendedor.getDsnombres());
            statement.setString(4, vendedor.getDsapellido());
            statement.setString(5, vendedor.getDsdireccion());
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

    public void update(Vendedor vendedor) throws DaoException {
        String UPDATE = "UPDATE vendedor\n" +
                "SET documento=?\n" +
                "dsnombres=?\n" +
                "dsapellidos=?\n" +
                "dsdireccion=?\n" +
                "WHERE nmvendedor=?";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, vendedor.getDocumento());
            statement.setString(2, vendedor.getDsnombres());
            statement.setString(3, vendedor.getDsapellido());
            statement.setString(4, vendedor.getDsdireccion());
            statement.setInt(5, vendedor.getNmvendedor());
            System.out.println(statement);

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

    public void delete(Vendedor vendedor) throws DaoException {
        try {

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Vendedor selectbyid(Vendedor vendedor) throws DaoException {
        Vendedor _result = null;
        String SELECT = "SELECT nmvendedor,documento,dsnombres,dsapellidos,dsdireccion\n" +
                "FROM vendedor\n" +
                "WHERE nmvendedor=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = ManagerConexion.getInstance().getConnection();
        System.out.println(connection);

        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, vendedor.getNmvendedor());

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                _result = new Vendedor();
                _result.setNmvendedor(resultSet.getInt("nmvendedor"));
                _result.setDocumento(resultSet.getString("documento"));
                _result.setDsnombres(resultSet.getString("dsnombres"));
                _result.setDsapellido((resultSet.getString("dsapellidos")));
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

    public List<Vendedor> selectAll() throws DaoException {
        List<Vendedor> lista = new ArrayList<>();
        String SELECT = "SELECT nmclient,documento,dsnombres,dsapellidos,dsdireccion FROM vendedor";


        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //Obtengo la conexión
        Connection connection = ManagerConexion.getInstance().getConnection();

        try {
            statement = connection.prepareStatement(SELECT);


            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vendedor _result = new Vendedor();
                _result.setNmvendedor(resultSet.getInt("nmcliente"));
                _result.setDocumento(resultSet.getString("documento"));
                _result.setDsnombres(resultSet.getString("dsnombres"));
                _result.setDsapellido(resultSet.getString("dsapellidos"));
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

package com.dao;

import com.dto.ClientDTO;
import com.db.ConnectionJDBC;

import java.util.*;
import java.sql.*;


public class ClientDAO {

    private static final String SQL_INSERT = "INSERT INTO client(firstName,lastName,description) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE client SET firstName = ?, lastName = ?, description = ? WHERE idClient= ?";
    private static final String SQL_DELETE = "DELETE FROM client WHERE idClient = ?";
    private static final String SQL_SELECT = "SELECT * FROM client WHERE idClient = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM client";

    public int insert(ClientDTO client) throws SQLException {

        Connection conn = ConnectionJDBC.getConnection();
        int rows;

        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);

        int index = 1;
        stmt.setString(1,client.getName());
        stmt.setString(2, client.getLastName());
        stmt.setString(3, client.getDescription());

        System.out.println("Adding client to DB...");

        rows = stmt.executeUpdate();// this returns an int with the number of modified records


        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return rows;

    }

    public int update(ClientDTO client) throws SQLException {

        Connection conn = ConnectionJDBC.getConnection();
        int rows = 0;

        PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);

        int index = 1;
        stmt.setString(index++,client.getName());
        stmt.setString(index++, client.getLastName());
        stmt.setString(index++, client.getDescription());
        stmt.setInt(index, client.getID());

        System.out.println("Updating client to DB...");

        rows = stmt.executeUpdate();// this returns an int with the number of modified records


        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return rows;

    }

    public int delete(ClientDTO client) throws SQLException {

        Connection conn = ConnectionJDBC.getConnection();
        int rows = 0;

        PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);

        int index = 1;
        stmt.setInt(index,client.getID());


        System.out.println("Deleting client to DB...");

        rows = stmt.executeUpdate();// this returns an int with the number of modified records


        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return rows;

    }

    public ClientDTO select(int id) throws SQLException {

        ResultSet rs = null;
        Connection conn = ConnectionJDBC.getConnection();
        int rows = 0;

        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);



        int index = 1;
        stmt.setInt(index, id);

        rs = stmt.executeQuery();

        System.out.println("Searching for client...");

        int idClient = rs.getInt(1);
        String name = rs.getString(2);
        String lastName = rs.getString(3);
        String description = rs.getString(4);

        if(name != null) {

            ClientDTO cl = new ClientDTO(name,lastName,description);
            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
            return cl;

        } else {

            ConnectionJDBC.close(rs);
            ConnectionJDBC.close(stmt);
            ConnectionJDBC.close(conn);
            return null;
        }
    }

    public ArrayList<ClientDTO> selectAll() throws SQLException {

        Connection conn = ConnectionJDBC.getConnection();
        ArrayList<ClientDTO> clients = new ArrayList<ClientDTO>();


        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ALL);
        ResultSet rs = stmt.executeQuery();


        while (rs.next()) {

            int idClient = rs.getInt(1);
            String name = rs.getString(2);
            String lastName = rs.getString(3);
            String description = rs.getString(4);

            ClientDTO cli = new ClientDTO(name, lastName, description);
            cli.setID(idClient);

            clients.add(cli);

        }

        ConnectionJDBC.close(rs);
        ConnectionJDBC.close(stmt);
        ConnectionJDBC.close(conn);


        return clients;

    }
}

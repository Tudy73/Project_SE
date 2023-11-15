package com.example.demo2.Model;


import java.sql.*;


public class Connection {
    public String url;
    public String user;
    public String password;
    public String tableName;

    public Connection(String tableName) {
        this.url = "jdbc:postgresql://localhost:5432/postgres";
        this.user = "postgres";
        this.password = "varanudorm";
        this.tableName = tableName;
    }

    public int tableSize(String tableName) {
        String query = "SELECT * FROM " + tableName;
        int tableSize = 0;
        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                tableSize++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tableSize;
    }

    public String getName(int index) {
        String query = "SELECT * FROM hello";
        String id_c = Integer.toString(index);
        String name = " ";
        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("id").equals(id_c)) {
                    name = resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

}

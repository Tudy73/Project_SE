package com.example.demo2;


import java.sql.*;


public class Connect {
    public String url;
    public String user;
    public String password;
    public String tableName;

    public Connect(String tableName) {
        this.url = "jdbc:postgresql://localhost:5432/postgres";
        this.user = "postgres";
        this.password = "varanudorm";
        this.tableName = tableName;
    }

    public int tableSize(String tabelName) {
        String query = "SELECT * FROM " + tabelName;
        int i = 0;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement ps = connection.createStatement();
        ) {
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    public String getName(int t) {
        String query = "SELECT * FROM hello";
        String id_c = Integer.toString(t);
        String rez = " ";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement ps = connection.createStatement();
        ) {
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("id").equals(id_c)) {
                    rez = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rez;
    }

}

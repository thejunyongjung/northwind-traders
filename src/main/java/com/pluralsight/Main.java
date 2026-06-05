package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("dkrkEk0102");

        String sql = "SELECT ProductName FROM products";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("ProductName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
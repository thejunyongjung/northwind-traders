package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;

public class PT2 {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("dkrkEk0102");

        String sql = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.printf("%-5s %-35s %8s %6s%n", "Id", "Name", "Price", "Stock");
            System.out.println("----- ----------------------------------- -------- ------");

            while (rs.next()) {
                System.out.printf("%-5d %-35s %8.2f %6d%n",
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getDouble("UnitPrice"),
                        rs.getInt("UnitsInStock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.sendemail.senderemail;
import java.sql.*;

public class Data {
    private static String username;
    private static String email;
    private static String password;
    public Data(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    private static String url = "jdbc:mysql://localhost:3306/user_credentials"; 
    private static String user = "root";
    private static String pass = ""; 
    
    // insert to the database
    public void saveToDatabase() {
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            // query for my sql
            String query = "INSERT INTO USERS (username, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);

                int new_row  = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // login checker
    public static boolean loginChecker(String users_username, String users_password) {
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String query = "SELECT * FROM USERS";
            try (PreparedStatement checker = connection.prepareStatement(query)) {
                checker.setString(1, username);
                checker.setString(2, email);
                checker.setString(3, password);

                ResultSet check  = checker.executeQuery();

                if (!check.isBeforeFirst()) return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}

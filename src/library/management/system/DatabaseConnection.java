package library.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/library_management_system";
        private static final String USER = "root"; // replace with your MySQL username
        private static final String PASSWORD = "12#@12Ab"; // replace with your MySQL password

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }


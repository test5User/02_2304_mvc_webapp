package by.itclass.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/po_2304";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";

    private static Connection cn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (cn == null || cn.isClosed()) {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return cn;
    }
}

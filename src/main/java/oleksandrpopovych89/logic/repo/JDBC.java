package oleksandrpopovych89.logic.repo;

import oleksandrpopovych89.logic.essence.Equipment;
import oleksandrpopovych89.logic.essence.Order;

import java.sql.*;

public class JDBC {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mydb";
    static final String USER = "root";
    static final String PASSWORD = "1123";
    private static Connection conn = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps;

    static {
        try {
            connectToDB();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private JDBC() {
    }

    //Connect to DB
    public static void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        System.out.println("Connecting to database...");
    }
}

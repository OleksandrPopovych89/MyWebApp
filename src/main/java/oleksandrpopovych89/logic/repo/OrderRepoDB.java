package oleksandrpopovych89.logic.repo;

import oleksandrpopovych89.logic.essence.Equipment;
import oleksandrpopovych89.logic.essence.Order;

import java.sql.*;

public class OrderRepoDB {
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

    private OrderRepoDB() {
    }

    //Connect to DB
    public static void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        System.out.println("Connecting to database...");
    }


    //CRUD

    public static void createOrder(Integer orderId) throws SQLException, InterruptedException {
        System.out.println("Creating order" + orderId);
        String sql = "CREATE TABLE if not exists `" + orderId + "`" +
                "(id int not null auto_increment, " +
                " name VARCHAR(255), " +
                " shortName VARCHAR(255), " +
                " vendorName VARCHAR(255), " +
                " vendorCode VARCHAR(255), " +
                " units VARCHAR(255), " +
                " quantity VARCHAR(255), " +
                " PRIMARY KEY (id))";
        System.out.println(sql);
        st = conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("Table Equipment was be created");
    }


    public static void addNewPosition(Integer orderId) throws SQLException {
        System.out.println("Adding equipment to the table...");
        String sql = "INSERT INTO `" + orderId + "` (name, shortName, vendorName, vendorCode, units, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, null);
        ps.setString(2, null);
        ps.setString(3, null);
        ps.setString(4, null);
        ps.setString(5, null);
        ps.setInt(6, 0);
        ps.executeUpdate();
    }

    public static void deletePositionById(Integer orderId, Integer positionId) throws SQLException {
        String sql = "DELETE FROM `" + orderId + "` WHERE id =" + positionId;
        st = conn.createStatement();
        st.execute(sql);
    }

    public static void truncateTable(Order order) throws SQLException, InterruptedException {
        String sql = "TRUNCATE TABLE `" + order.getOrderId() + "`";
        ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        System.out.println("Clear table");
    }


    public static Order findOrderById(Integer orderId) throws SQLException {
        st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "SELECT * FROM `" + orderId + "`";
        System.out.println(sql);
        rs = st.executeQuery(sql);
        Order order;
        order = convResSetTOrder(rs);
        order.setOrderId(orderId);
        System.out.println(order);
        return order;
    }

    //Utils
    private static Order convResSetTOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        System.out.println("From convert");
        while (rs.next()) {
            order.getEquipmentList().add(new Equipment(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("shortName"),
                    rs.getString("vendorName"),
                    rs.getString("vendorCode"),
                    rs.getString("units"),
                    rs.getInt("quantity")));
        }
        return order;
    }

    public static void copyOrderById(Integer orderId, Integer newOrderId) throws SQLException, InterruptedException {
        st = conn.createStatement();
        createOrder(newOrderId);
        String sql = "INSERT INTO `" + newOrderId + "` SELECT * FROM `" + orderId + "`";
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }


    public static void deleteOrderById(Integer orderId) throws SQLException {
        st = conn.createStatement();
        String sql = "DROP TABLE `" + orderId + "`";
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }
}
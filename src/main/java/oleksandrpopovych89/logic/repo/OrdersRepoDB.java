package oleksandrpopovych89.logic.repo;

import com.mysql.cj.protocol.ResultsetRow;
import oleksandrpopovych89.logic.essence.Equipment;
import oleksandrpopovych89.logic.essence.Order;
import oleksandrpopovych89.logic.essence.OrderInfo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class OrdersRepoDB {
    private static OrdersRepoDB eRepositoryDB = null;
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

    private OrdersRepoDB() {
    }

    public static OrdersRepoDB getEquipmentRepositoryDB() {
        if (eRepositoryDB == null) {
            eRepositoryDB = new OrdersRepoDB();
        }
        return eRepositoryDB;
    }

    //Connect to DB
    public static void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        System.out.println("Connecting to database...");
    }

    //CRUD
    public static void crOrTab() throws SQLException, InterruptedException {
        System.out.println("Creating orders table.");

        String sql = "CREATE TABLE if not exists order_list" +
                "`(order_id int not null auto_increment, " +
                " order_create_time DATA (), " +
                " order_save_time DATA , " +
                " PRIMARY KEY (id))";

        System.out.println(sql);
        st = conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("Table Equipment was be created");
    }

    public static Integer addNewOrder() throws SQLException {
        java.util.Date currentDate = new java.util.Date();
        Date date = new Date(currentDate.getTime());
        String sql = "INSERT INTO order_list (order_create_time ,order_save_time) VALUES (?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setDate(1, date);
        ps.setDate(2, date);
        ps.executeUpdate();
        return getLastAddId();
    }

    public static Integer getLastAddId() throws SQLException {
        Integer index = 0;
        st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "SELECT MAX(order_id)FROM order_list;";
        System.out.println(sql);
        rs = st.executeQuery(sql);
        while (rs.next()) {
            index = rs.getInt("MAX(order_id)");
        }
        return index;
    }

    public static void deleteOrderFromOrderList(Integer orderId) throws SQLException {
        st = conn.createStatement();
        String sql = "DELETE FROM order_list where order_id=" + orderId;
        st.execute(sql);
    }

    public static void truncateTable() throws SQLException, InterruptedException {
        String sql = "TRUNCATE TABLE order_list";
        ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        System.out.println("Clear table");
    }


    public static List<OrderInfo> readOrder() throws SQLException {
        st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "SELECT * FROM order_list";
        System.out.println(sql);
        rs = st.executeQuery(sql);
        List<OrderInfo> ordersInfo;
        ordersInfo = convResSetTOrders(rs);
        return ordersInfo;
    }

    //Utils
    private static List<OrderInfo> convResSetTOrders(ResultSet rs) throws SQLException {
        List<OrderInfo> ordersInfo = new ArrayList<>();
        System.out.println("From convert");
        Integer tempNumber;

        Date tempDataOfCreate;
        Date tempDataOfLastSave;

        while (rs.next()) {
            tempNumber = rs.getInt("order_id");

            tempDataOfCreate = rs.getDate("order_create_time");

            tempDataOfLastSave = rs.getDate("order_save_time");

            ordersInfo.add(new OrderInfo(tempNumber, tempDataOfCreate, tempDataOfLastSave));
        }
        return ordersInfo;
    }
}
package oleksandrpopovych89.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oleksandrpopovych89.logic.essence.Order;
import oleksandrpopovych89.logic.repo.OrderRepoDB;
import oleksandrpopovych89.logic.repo.OrdersRepoDB;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete-order")
public class DeleteOrderController extends HttpServlet {

    private Order order;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            OrderRepoDB.deleteOrderById(id);
            OrdersRepoDB.deleteOrderFromOrderList(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/orders-list");
    }
}
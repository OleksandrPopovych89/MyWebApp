package oleksandrpopovych89.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oleksandrpopovych89.logic.essence.OrderInfo;
import oleksandrpopovych89.logic.repo.OrderRepoDB;
import oleksandrpopovych89.logic.repo.OrdersRepoDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/orders-list")
public class OrdersListController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/orders-list.jsp");
        try {
            request.setAttribute("ordersList", OrdersRepoDB.readOrder());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        requestDispatcher.forward(request, response);
    }
}
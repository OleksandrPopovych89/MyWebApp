package oleksandrpopovych89.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oleksandrpopovych89.logic.repo.OrderRepoDB;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete-position")
public class DeletePositionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer orderId = Integer.parseInt((request.getParameter("oid")));
        Integer positionId = Integer.parseInt((request.getParameter("pid")));
        try {
            OrderRepoDB.deletePositionById(orderId, positionId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/order-list?id=" + orderId);
    }
}
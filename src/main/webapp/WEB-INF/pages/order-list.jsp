<%@ page import="oleksandrpopovych89.logic.essence.Order" %>
<%@ page import="oleksandrpopovych89.logic.essence.Equipment" %>
<%@ page import="oleksandrpopovych89.logic.repo.OrderRepoDB" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.04.2022
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Order order = (Order) request.getAttribute("order");
%>
<html>
<head>
    <title>Замовлення №<%=order.getOrderId()%>
    </title>
</head>
<body>
<h3>
    <a href="${pageContext.request.contextPath}/orders-list">< Повернутися до листа замовленнь </a>
</h3>
<div style="text-align: center;">
    <h2>Замовлення №<%=order.getOrderId()%>
    </h2>
</div>

<div style="text-align: center;">
    <h4>
        <a href="${pageContext.request.contextPath}/add-new-position?id=<%=order.getOrderId()%>"> Додати нову
            позицію</a>
    </h4>
</div>
<table border="1" , style="margin: 0 auto; border: solid 2px black;">
    <tr>
        <th>№ по порядку</th>
        <th>Найменування</th>
        <th>Позначення</th>
        <th>Артикул</th>
        <th>Виробник</th>
        <th>Од. вимірювання</th>
        <th>Кількість</th>
        <th colspan="1">Операції</th>
    </tr>
    <%
        int i;
        for (i = 0; i < order.getEquipmentList().size(); i++) {


    %>

    <tr>
        <td style="text-align: center;">
                <%=i+1%>
        <td><%=order.getEquipmentList().get(i).getName()%>
        <td><%=order.getEquipmentList().get(i).getShortName()%>
        <td><%=order.getEquipmentList().get(i).getVendorCode()%>
        <td style="text-align: center;"><%=order.getEquipmentList().get(i).getVendorName()%>
        <td style="text-align: center;"><%=order.getEquipmentList().get(i).getUnits()%>
        <td style="text-align: center;"><%=order.getEquipmentList().get(i).getQuantity()%>
        <td>
            <a href="${pageContext.request.contextPath}/delete-position?oid=<%=order.getOrderId()%>&pid=<%=order.getEquipmentList().get(i).getEqId()%>">Видалти
                позицію </a></td>

    </tr>
    <%
        }
    %>
</table>



</body>
</html>

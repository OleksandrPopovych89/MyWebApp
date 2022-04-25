<%@ page import="oleksandrpopovych89.logic.essence.Order" %>
<%@ page import="oleksandrpopovych89.logic.essence.Equipment" %>
<%@ page import="java.util.List" %>
<%@ page import="oleksandrpopovych89.logic.essence.OrderInfo" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.04.2022
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<OrderInfo> orderInfoList = (List<OrderInfo>) request.getAttribute("ordersList");
%>
<html>
<head>
    <title>Список замовленнь</title>
</head>
<body>

<div style="text-align: center;">
    <h2>Лист замовленнь </h2>

    <h4>
        <a href="/create-order"> Створити нове замовлення</a>
    </h4>

    </p>

</div>


<table border="1" , style="margin: 0 auto; border: solid 2px black;">
    <tr>
        <th>№ замовлення</th>
        <th>Дата створення замовлення</th>
        <th>Дата останнього редагування замовлення</th>
        <th colspan="3">Операції</th>

    </tr>
    <%
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        int i;
        for (i = 0; i < orderInfoList.size(); i++) {


    %>

    <tr>
        <td style="text-align: center;">Замовлення №<%=orderInfoList.get(i).getOrderId()%>
        <td style="text-align: center;"><%=simpleDateFormat.format(orderInfoList.get(i).getDateOfCreate())%>
        <td style="text-align: center;"><%=simpleDateFormat.format(orderInfoList.get(i).getDateOfLastSave())%>

        <td><a href="/order-list?id=<%=orderInfoList.get(i).getOrderId()%>">Відкрити замовлення</a></td>
        <td><a href="/delete-order?id=<%=orderInfoList.get(i).getOrderId()%>">Видалти замовлення </a></td>
        <td><a href="/copy-order?id=<%=orderInfoList.get(i).getOrderId()%>">Скопіювати замовлення </a></td>

    </tr>
    <%
        }
    %>
</table>


</body>
</html>

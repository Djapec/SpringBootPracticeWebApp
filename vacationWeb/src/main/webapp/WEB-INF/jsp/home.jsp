<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border:1px solid black;
        }
    </style>
</head>
<body>
    <h3>Total number of unused vacation days among all users</h3>
    <p>${total}</p>

    <h3>Average number of unused vacation days among all users</h3>
    <p>${avg}</p>

    <h3>Percentage of users that used all vacation days for the current year</h3>
    <p>${percent}%</p>

    <h3>The number of used vacation days for each month among all users</h3>
    <table style="width:auto">
        <thead>
        <tr>
            <th>Month</th>
            <th>Used days</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="month" items="${monthList}">
            <tr>
                <td>${month.key}</td>
                <td>${month.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
<a href="/employees">Employees</a>

</body>
</html>

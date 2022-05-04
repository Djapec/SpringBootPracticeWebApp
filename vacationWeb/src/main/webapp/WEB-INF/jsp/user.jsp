<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User</title>
    <style>
        table, th, td {
            border:1px solid black;
        }
    </style>
</head>
<body>
    <h1>${user}</h1>
    <br>
    <h3>Total number of vacation days for each year</h3>
    <table style="width:auto">
        <thead>
        <tr>
            <th>Year</th>
            <th>Vacation days</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="days" items="${daysPerYear}">
            <tr>
                <td>${days.employeeCompositeKey.year}</td>
                <td>${days.totalVacationDays}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<br>
    <h3>Total number of unused vacation days for each year</h3>
    <table style="width:auto">
        <thead>
        <tr>
            <th>Year</th>
            <th>Unused vacation days</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="days" items="${unusedDaysPerYear}">
            <tr>
                <td>${days.key}</td>
                <td>${days.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <h3>Number of vacation days used for each month</h3>
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

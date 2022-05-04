<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
    <h1>List of employees</h1>
    <ol>
        <c:forEach var="emp" items="${empList}" >
            <li id="${emp}" onclick="httpGet(this.id)">${emp}</li>
        </c:forEach>
    </ol>

</body>
<script>
    function httpGet(id) {
        let data = document.getElementById(id);
        console.log(data.innerText)
        let host = window.location.protocol + "//" + window.location.host;
        let url =host+"/user?id="+data.innerText
        location.replace(url);
    }
</script>

</html>

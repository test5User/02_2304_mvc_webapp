<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <c:set var="number" value="26" scope="page"/>
    <p>result : ${number + 15}</p>

    <c:remove var="number"/>
    <p>result : ${number + 15}</p>

    <c:if test="${number == null}">
        <p>Variable is not exist or null</p>
    </c:if>
    <c:if test="${empty number}">
        <p>Variable is not exist or null</p>
    </c:if>

    <c:set var="result" value="${number + 15}" scope="page"/>

    <c:choose>
        <c:when test="${result == 15}">
            <p>Result value is 15</p>
        </c:when>
        <c:when test="${result == 26}">
            <p>Result value is 26</p>
        </c:when>
        <c:otherwise>
            <p>Bad value</p>
        </c:otherwise>
    </c:choose>

    <c:url var="linkUrl" value="http://google.com"/>
    This is the <a href="${linkUrl}">google</a>

    <c:url var="link" value="http://google.com/search">
        <c:param name="q" value="Bobr" />
    </c:url>
    This is the <a href="${link}">bobr</a>

    <ol>
        <c:forEach var="cook" items="${cookie}">
            <li>
                <p>${cook.value.name} : ${cook.value.value}</p>
            </li>
        </c:forEach>
    </ol>
</body>
</html>

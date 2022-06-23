<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />
<footer>
    <p>©
     <c:choose>
        <c:when test="${year == '2022'}">
            ${year}
        </c:when>
        <c:otherwise>
            ${year} - 2022
        </c:otherwise>
    </c:choose>
     | nathan flacher</p>
    <p>réseaux</p>
</footer>
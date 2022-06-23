<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <%@ include file="/WEB-INF/component/meta-data.jsp" %>
    <title>page not found</title>
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.currentUser ne null}">
            <%@ include file="/WEB-INF/component/nav-connected.jsp" %>
        </c:when>
        <c:otherwise>
            <%@ include file="/WEB-INF/component/nav-anonymous.jsp" %>
        </c:otherwise>
    </c:choose>
    <main>
        <h1 align="center">erreur 404</h1>
    </main>
    <%@ include file="/WEB-INF/component/footer.jsp" %>
    <%@ include file="/WEB-INF/component/scripts.jsp" %>
</body>
</html>
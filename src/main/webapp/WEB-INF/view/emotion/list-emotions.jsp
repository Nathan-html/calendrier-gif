<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <%@ include file="/WEB-INF/component/meta-data.jsp" %>
    <title>${title} | émotions</title>
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
    <main class="emotions-list">
        <h1 align="center">Émotions <a href="emotion/create">+</a></h1>
        <ul>
            <c:forEach items="${emotions}" var="emotion">
                <li>${emotion.code} | ${emotion.name}</li>
            </c:forEach>
        </ul>
        <p><a href="emotion/create">Crée une émotion</a></p>
    </main>
    <%@ include file="/WEB-INF/component/footer.jsp" %>
    <%@ include file="/WEB-INF/component/scripts.jsp" %>
</body>
</html>
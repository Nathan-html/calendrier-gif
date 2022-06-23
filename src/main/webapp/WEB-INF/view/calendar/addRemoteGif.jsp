<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <%@ include file="/WEB-INF/component/meta-data.jsp" %>
    <title>${title} | Ajouter un Gif</title>
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
    <h1 align="center">Ajouter un gif herberger sur une application tiers</h1>
    <form action="create-remote-gif" name="remote-gif" method="post">
        <div>
            <label for="url">url</label>
            <input placeholder="https://giphy.com/gifs/LXONhtCmN32YU" type="url" id="url" name="url" maxlength="150">
        </div>
        <div>
            <label for="description">description</label>
            <input type="text" id="description" name="description" maxlength="150">
        </div>
        <button type="submit">Ajouter le gif</button>
    </form>
</main>
<%@ include file="/WEB-INF/component/footer.jsp" %>
<%@ include file="/WEB-INF/component/scripts.jsp" %>
</body>
</html>
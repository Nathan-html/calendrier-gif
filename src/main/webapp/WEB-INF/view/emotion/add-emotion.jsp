<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <%@ include file="/WEB-INF/component/meta-data.jsp" %>
    <title>${title} | crée une émotion</title>
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
        <h1 align="center">Crée une émotion</h1>
        <form name="create-emotion" method="post">
            <div class="form-group">
                <label for="name">Nom</label>
                <input type="text" id="name" name="name" minlength="4" maxlength="50">
            </div>
            <div class="form-group">
                <label for="code">Code</label>
                <input type="text" id="code" name="code" maxlength="16">
            </div>
            <p class="info">Entrer le code hexadécimal de l'emoji que vous souhaitez ou importer directement l'emoji </p>
            <button type="submit">Crée la reaction</button>
        </form>
    </main>
    <%@ include file="/WEB-INF/component/footer.jsp" %>
    <%@ include file="/WEB-INF/component/scripts.jsp" %>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <%@ include file="/WEB-INF/component/meta-data.jsp" %>
    <title>${title} | connexion</title>
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
        <h1 align="center">Connectez-vous</h1>
        <form action="login" name="login" method="post">
            <div>
                <label for="email">Email</label>
                <input type="email" id="email" name="email" minlength="4" maxlength="50">
            </div>
            <div>
                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" minlength="4" maxlength="16">
            </div>
            <button type="submit">Se connecter</button>
        </form>
        <p align="center">Vous n'avez pas de compte, <a href="/register">inscrivez-vous</a></p>
    </main>
    <%@ include file="/WEB-INF/component/footer.jsp" %>
    <%@ include file="/WEB-INF/component/scripts.jsp" %>
</body>
</html>
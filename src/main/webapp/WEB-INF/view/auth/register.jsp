<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <%@ include file="/WEB-INF/component/meta-data.jsp" %>
    <title>${title} | inscription</title>
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
        <h1 align="center">Inscrivez-vous</h1>
        <form action="register" name="register" method="post">
            <div>
                <label for="firstname">prénom</label>
                <input type="text" id="firstname" name="firstname" maxlength="50">
            </div>
            <div>
                <label for="lastname">nom</label>
                <input type="text" id="lastname" name="lastname" maxlength="16">
            </div>
            <div>
                <label for="email">email</label>
                <input type="email" id="email" name="email" maxlength="50">
            </div>
            <div>
                <label for="password">mot de passe</label>
                <input type="password" id="password" name="password" maxlength="16">
            </div>
            <div>
                <label for="confirm-password">confirmation</label>
                <input type="password" id="confirm-password" name="confirm-password" maxlength="16">
            </div>
            <div>
                <label for="theme">theme</label>
                <select id="theme" name="theme">
                    <c:forEach items="${themes}" var="theme">
                        <option value="${theme.id}">${theme.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">Se connecter</button>
        </form>
        <p align="center">Vous avez déjà un compte, <a href="/">connectez-vous</a></p>
    </main>
    <%@ include file="/WEB-INF/component/footer.jsp" %>
    <%@ include file="/WEB-INF/component/scripts.jsp" %>
</body>
</html>
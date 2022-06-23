<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">
<head>
    <%@ include file="/WEB-INF/component/meta-data.jsp" %>
    <title>${title}</title>
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
    <main class="calendar">
        <h1 align="center">Calendrier</h1>
        <div class="list-card">
            <c:forEach items="${days.content}" var="day">
                <div class="calendar-card">
                    <div class="card-img">
                        <c:choose>
                            <c:when test="${day.gif.user.lastname ne null}">
                                <div class="img">
                                    <img src="https://via.placeholder.com/200.gif" >
                                </div>
                                <p class="img-label">${day.gif.user.lastname}</p>
                            </c:when >
                            <c:otherwise>
<%--                                <img src="https://via.placeholder.com/200.gif" >--%>
                                <div class="img"></div>
                                <div class="links">
                                    <p class="img-link"><a href="/calendar/add-remote-gif?day=${day.date}">Placer un Gif distant</a></p>
                                    <p class="img-link"><a href="/calendar/add-local-gif?day=${day.date}">Téléverser un Gif</a></p>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="card-info">
                        <p>${day.date}</p>
                        <c:choose>
                            <c:when test="${day.gif.id eq null}">
                                <p>40 points</p>
                            </c:when>
                            <c:otherwise>
                                <p><a href="calendar/react?gif=${day.gif.id}">Réagir</a></p>
                                <ul>
                                    <c:forEach items="${day.gif.reactions}" var="reaction">
                                        <li${reaction.emotion.code} - ${reaction.utilisateur.prenom}</li>
                                    </c:forEach>
                                </ul>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="pageable">
            <c:choose>
                <c:when test="${!days.isFirst()}">
                    <p><a href="calendar?page=0">Premier</a></p>
                    <p><a href="calendar?page=${days.number-1}">Précédent</a></p>
                </c:when>
                <c:otherwise>
                    <p>Premier</p>
                    <p>Précédent</p>
                </c:otherwise>
            </c:choose>
            <p>page ${days.getNumber()+1}</p>
            <c:choose>
                <c:when test="${!days.last}">
                    <p><a href="calendar?page=${days.number+1}">Suivant</a></p>
                    <p><a href="calendar?page=${days.totalPages - 1}">Dernier</a></p>
                </c:when>
                <c:otherwise>
                    <p>Suivant</p>
                    <p>Dernier</p>
                </c:otherwise>
            </c:choose>
        </div>
    </main>
    <%@ include file="/WEB-INF/component/footer.jsp" %>
    <%@ include file="/WEB-INF/component/scripts.jsp" %>
</body>
</html>
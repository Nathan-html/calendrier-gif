<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <p><a href="/calendar">Calendrier gif</a></p>
    <ul>
        <li><a href="/logout">Déconnexion</a></li>
        <li><a href="/emotion">Émotions</a></li>
        <li>${sessionScope.currentUser.firstname} ${sessionScope.currentUser.lastname}</li>
    </ul>
</nav>
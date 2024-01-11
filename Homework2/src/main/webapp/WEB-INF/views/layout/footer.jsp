<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<footer class="fixed-bottom mt-auto py-3" id="footer">
        <div class="container">
            <div class="text-center">
                <strong>Copyright@</strong>
                <span class="text-muted">Marc Sanchez marc.sanchez@urv.cat</span>
            </div>
            <h1>Lista de Videojuegos</h1>
            <ul>
                <c:forEach var="game" items="${SignUpFormController.games}">
                <li>
                    ${game.disponibilitat}<br>
                    ${game.id}<br>
                    ${game.nom}<br>
                    ${game.preuLloguer}<br>
                    ${game.videoconsola}<br>
                </li>
                </c:forEach>
            </ul>
        </div>
</footer>

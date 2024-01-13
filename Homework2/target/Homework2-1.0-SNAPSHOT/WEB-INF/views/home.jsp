<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>GameShop</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css" />
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.svg" type="image/x-icon">


<!-- FontAwesome -->
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous"/>
<style>
        
    </style>
</head>
<body>
    <h1 id="first-title">GameShop</h1>

    <div class="card-container">
        <c:forEach var="videojuego" items="${games}">
            <div class="card">
                <h2>${videojuego.nom}</h2>
                <p>Precio: ${videojuego.preuLloguer}€</p>
                <p>${videojuego.disponibilitat ? 'Disponible' : 'No disponible'}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>

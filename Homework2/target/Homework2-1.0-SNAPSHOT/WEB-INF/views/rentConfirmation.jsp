<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rent Confirmation</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
        
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.svg" type="image/x-icon">


<!-- FontAwesome -->
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous"/>
    </head>
    <body>
        <p>Name: ${userName}</p>
        <c:if test="${buyConfirmed}">
            <h1>Receipt</h1>
            <p>Rent ID: ${rebutLloguer.id}</p>
            <p>Fecha de Inicio: ${rebutLloguer.dataInici}</p>
            <p>Fecha de Fin: ${rebutLloguer.dataFi}</p>
            <p>Precio Total: ${rebutLloguer.preuTotal}</p>
        </c:if>
            
        <c:if test="${!buyConfirmed}">
            <h1>Rent Confirmation</h1>
            
            <p>Rent time: 1 week</p>
            <p>${game.nom}</p>
            <p>Price: ${game.preuLloguer}</p>
            <form action="${mvc.uri('rent')}" method="post">
                <input type="hidden" name="gameId" value="${game.id}">
                <input type="hidden" name="userName" value="${userName}">
                <button id="addtocart" type="submit">BUY IT</button>
            </form>
        </c:if>
        
        <a href="Main">Volver a la página principal</a>
    </body>
</html>

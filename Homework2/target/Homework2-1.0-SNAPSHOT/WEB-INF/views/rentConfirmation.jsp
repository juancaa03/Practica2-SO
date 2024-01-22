<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Rent Confirmation</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/rentConfirmation.css" />
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.svg" type="image/x-icon">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Black+Ops+One&display=swap">

<!-- FontAwesome -->
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous"/>
    </head>
    <body>
        <div class="bg-dark d-flex align-text-center justify-items-center">
            <div class="container">
                <p>Hi, ${userName}!</p>
        
                <h1>Rent Confirmation</h1>
            
                <p>Rent time: 1 week</p>
                <p>${game.nom}</p>
                <p>Price: ${game.preuLloguer}</p>
                <form action="${mvc.uri('rent')}" method="post">
                    <input type="hidden" name="gameId" value="${game.id}">
                    <input type="hidden" name="userName" value="${userName}">
                    <button id="" type="submit">BUY IT</button>
                </form>
        
                <a href="Main">Volver a la página principal</a>
            </div>
        </div>
    </body>
</html>

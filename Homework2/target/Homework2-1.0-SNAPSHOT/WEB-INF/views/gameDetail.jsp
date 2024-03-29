<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${game.nom}</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/game.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Black+Ops+One&display=swap">
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
        <c:if test="${addedToCart}">
                    <div class="cart">
                        <h2>Shopping Cart - ${userName}</h2>
                        <hr>
                        <p>${game.nom} - ${game.preuLloguer}€</p>
                    
                        <form action="Rent" method="get" target="_blank">
                            <input type="hidden" name="gameId" value="${game.id}">
                            <input type="hidden" name="userName" value="${userName}">
                            <button type="submit">RENT ME</button>
                        </form>
                    </div>
                </c:if>
        
        <div class="container">
            
        <div class="row">
            
            <div class="col-md-6">
                <img src="${pageContext.request.contextPath}/resources/img/${game.nom}.jpg" alt="${game.nom}" class="gameImage">
            </div>
            <div class="col-md-6 letra">
                <c:if test="${isLoggedIn}">
                    <p id="hi">Hi, ${userName}!</p>
                </c:if>
                <h2>${game.nom}</h2>
                <hr>
                <p>Precio: ${game.preuLloguer}€</p>
                <p>Tipo: ${game.tipus}</p>
                <p>Descripción: ${game.descripcio}</p>
                <p style="color: ${game.disponibilitat ? 'greenyellow' : 'red'}">${game.disponibilitat ? 'Disponible' : 'No disponible'}</p>
                <p>Tipo de videoconsola: ${game.videoconsola}</p>
                <p>Dirección de la tienda: ${game.adrecaBotigues}</p>
                
                <form action="${mvc.uri('addToCart')}" method="post">
                    <input type="hidden" name="gameId" value="${game.id}">
                    <input type="hidden" name="userName" value="${userName}">
                    <button id="addtocart" type="submit">ADD TO CART</button>
                </form>
                
            </div>
        </div>
        
    </div>
        
    </body>
</html>

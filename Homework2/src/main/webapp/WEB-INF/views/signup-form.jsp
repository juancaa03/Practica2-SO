<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>GameShop</title>
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
<style>
        body {
            font-family: Arial, sans-serif;
            color: #fff;
            background-color: #2A3B47;
        }
        
        #first-title {
            text-align: center;
            padding: 1em;
        }
        
        .card-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .card {
            width: 30%;
            margin: 1em;
            padding: 1em;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.3s ease-in-out;
        }

        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .card-img-top {
            width: 100%;
            height: auto;
            border-radius: 4px;
        }

        hr {
            border: 1px solid #ddd;
            margin: 8px 0;
        }
    </style>
</head>
<body>
    <h1 id="first-title">GameShop</h1>

    <div class="card-container">
        <c:forEach var="videojuego" items="${games}">
            <div class="card">
                <h2>${videojuego.nom}</h2>
                <p>Precio: ${videojuego.preuLloguer}</p>
                <p>${videojuego.disponibilitat ? 'Disponible' : 'No disponible'}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
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
    
    <c:if test="${isLoggedIn}">
        <h2 class="welcome">Welcome, ${usuari.nomUsuari}!</h2>
    </c:if>
    
    <div class="button-container">
        <c:if test="${not isLoggedIn}">
            <button type="button" id="loginB" class="btn btn-prymary Ibuttons" onclick="redirectToLogin()">Login</button>
        </c:if>
        <button type="button" id="filterB" class="btn btn-primary Ibuttons" onclick="mostrarFiltros()"><img src="${pageContext.request.contextPath}/resources/img/sliders-horizontal.svg" alt="alt" class=""/></button>
    </div>
    
    <form id="filtro-form">
        <div class="row">
            <div class="col-md-3">
                <div class="filter-menu">
                    <label>Type</label>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="accion" value="accion">
                        <label class="form-check-label" for="accion">Action</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="aventura" value="aventura">
                        <label class="form-check-label" for="aventura">Adventure</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="estrategia" value="estrategia">
                        <label class="form-check-label" for="estrategia">Strategy</label>
                    </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="filter-menu">
                    <label>Console</label>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="nintendo" value="nintendo">
                        <label class="form-check-label" for="nintendo">Nintendo</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="playstation" value="playstation">
                        <label class="form-check-label" for="playstation">PlayStation</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="xbox" value="xbox">
                        <label class="form-check-label" for="xbox">Xbox</label>
                    </div>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="filter-menu">
                    <label>Price</label>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="minPrice" value="minPrice">
                        <label class="form-check-label" for="minPrice">0 - 15€</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="midPrice" value="midPrice">
                        <label class="form-check-label" for="midPrice">15€ - 40€</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="maxPrice" value="maxPrice">
                        <label class="form-check-label" for="maxPrice">+ 40€</label>
                    </div>
                </div>
            </div>
        </div>

        <button type="button" id="aplyFilter" class="btn btn-primary Ibuttons" onclick="aplicarFiltro()">Aply</button>
    </form>
    
    <div class="container custom-container">
        <div class="row">
            <c:forEach var="videojuego" items="${games}">
                <div class="col-md-4">
                    <a href="gameDetail?id=${videojuego.id}" target="_blank">
                        <div class="card">
                            <img src="${pageContext.request.contextPath}/resources/img/quake.jpg" alt="Quake" class="gameImage">
                            <hr>
                            <h3>${videojuego.nom}</h3>
                            <p>${videojuego.preuLloguer}€</p>
                            <p class="disponibilidad">
                                <img src="${pageContext.request.contextPath}/resources/img/${videojuego.disponibilitat ? 'dispo.svg' : 'noDispo.svg'}" 
                 alt="${videojuego.disponibilitat ? 'Disponible' : 'No disponible'}" 
                 class="${videojuego.disponibilitat ? 'disponible-icon dIcon' : 'no-disponible-icon dIcon'}" />
            <span>${videojuego.disponibilitat ? 'Disponible' : 'No disponible'}</span>
                            </p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
    <script>
        function mostrarFiltros() {
        var filtroForm = document.getElementById("filtro-form");
        filtroForm.style.display = filtroForm.style.display === "none" ? "block" : "none";
    }
    
        function aplicarFiltro() {
        var tipoVideojuego = obtenerSeleccionados("tipoVideojuego");
        var videoconsola = obtenerSeleccionados("videoconsola");

        //Codigo para poder aplicar el filtro

        // Ejemplo de cómo podrías mostrar los valores seleccionados en la consola
        console.log("Tipo de Videojuego seleccionado: " + tipoVideojuego);
        console.log("Videoconsola seleccionada: " + videoconsola);
    }

    function obtenerSeleccionados(name) {
        var checkboxes = document.getElementsByName(name);
        var opcionesSeleccionadas = [];

        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                opcionesSeleccionadas.push(checkboxes[i].value);
            }
        }

        return opcionesSeleccionadas.join(",");
    }
    
    function redirectToLogin() {
        //window.open('Login', '_blank');
        window.location.href = 'Login';
    }
    </script>
</body>
</html>

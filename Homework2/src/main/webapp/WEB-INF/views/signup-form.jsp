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
    
    <button type="button" class="btn btn-primary filterB" onclick="mostrarFiltros()">Filtrar</button>
    
    <form id="filtro-form">
        <div class="row">
            <div class="col-md-3">
                <div class="filter-menu">
                    <label>Filtrar por Tipo:</label>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="accion" value="accion">
                        <label class="form-check-label" for="accion">Acción</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="aventura" value="aventura">
                        <label class="form-check-label" for="aventura">Aventura</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="estrategia" value="estrategia">
                        <label class="form-check-label" for="estrategia">Estrategia</label>
                    </div>
                    <!-- Agrega más opciones según tus tipos de videojuegos -->
                </div>
            </div>

            <div class="col-md-3">
                <div class="filter-menu">
                    <label>Filtrar por Videoconsola:</label>
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
                    <!-- Agrega más opciones según tus videoconsolas -->
                </div>
            </div>
        </div>

        <button type="button" class="btn btn-primary filterB" onclick="aplicarFiltro()">Aplicar Filtro</button>
    </form>
    
    <div class="card-container">
        <c:forEach var="videojuego" items="${games}">
            <div class="card">
                <h2>${videojuego.nom}</h2>
                <p>${videojuego.preuLloguer}€</p>
                <p>${videojuego.disponibilitat ? 'Disponible' : 'No disponible'}</p>
            </div>
        </c:forEach>
    </div>
    
    <script>
        function mostrarFiltros() {
        var filtroForm = document.getElementById("filtro-form");
        filtroForm.style.display = filtroForm.style.display === "none" ? "block" : "none";
    }
    
        function aplicarFiltro() {
        var tipoVideojuego = obtenerSeleccionados("tipoVideojuego");
        var videoconsola = obtenerSeleccionados("videoconsola");

        // Aquí puedes realizar una solicitud AJAX al servidor con los parámetros de filtro
        // y actualizar el contenido de la página sin recargarla

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
    </script>
</body>
</html>
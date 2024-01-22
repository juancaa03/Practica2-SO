<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Receipt</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/receipt.css" />

        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.svg" type="image/x-icon">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Black+Ops+One&display=swap">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Anton&display=swap">
        <!-- FontAwesome -->
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous"/>
    </head>
    <body>
        <div class="container">
            <h1>Receipt</h1>
            <p>Rent ID: ${rebutLloguer.id}</p>
            <p>Fecha de Inicio: ${rebutLloguer.dataAlquiler}</p>
            <p>Fecha de Fin: ${rebutLloguer.dataRetorn}</p>
            <p>Precio Total: ${rebutLloguer.preuTotal}</p>
            
            <a href="Main" target="_blank">Return to Store</a>
        </div>
    </body>
</html>

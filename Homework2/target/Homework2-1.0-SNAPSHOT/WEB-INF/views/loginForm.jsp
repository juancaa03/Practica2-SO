<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginForm.css" />
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
        <div class="container">
            
        
            <form action="${mvc.uri('authenticate')}" method="POST">
                <h1>Login with your Account</h1>
                
                <input type="text" id="userName" name="userName" placeholder="Enter your username" required>
        
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
        
                <button type="submit">LOGIN NOW</button>
            </form>
        </div>
    </body>
</html>

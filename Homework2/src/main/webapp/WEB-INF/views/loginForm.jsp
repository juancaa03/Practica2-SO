<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <form action="${pageContext.request.contextPath}/Login" method="post">
            <!-- Tus campos de usuario y contraseña aquí -->
            <input type="text" name="userName" />
            <input type="password" name="password" />
            <button type="submit">Login</button>
        </form>
    </body>
</html>

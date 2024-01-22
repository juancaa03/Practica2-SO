<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Receipt</h1>
            <p>Rent ID: ${rebutLloguer.id}</p>
            <p>Fecha de Inicio: ${rebutLloguer.dataAlquiler}</p>
            <p>Fecha de Fin: ${rebutLloguer.dataRetorn}</p>
            <p>Precio Total: ${rebutLloguer.preuTotal}</p>
            
            <a href="Main" target="_blank">Return to Store</a>
    </body>
</html>

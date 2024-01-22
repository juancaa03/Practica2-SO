<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rent Confirmation</title>
    </head>
    <body>
        <h1>Rent Confirmation</h1>
        <p>Rent ID: ${rebutLloguer.id}</p>
        <p>Fecha de Inicio: ${rebutLloguer.dataInici}</p>
        <p>Fecha de Fin: ${rebutLloguer.dataFi}</p>
        <p>Precio Total: ${rebutLloguer.preuTotal}</p>
        
        <a href="Main">Volver a la página principal</a>
    </body>
</html>

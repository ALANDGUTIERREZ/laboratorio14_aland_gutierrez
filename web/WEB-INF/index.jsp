
<%@taglib prefix="c" url= "http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Avisos clasificados</h1>
        <p><a href="inicio?action=add"></a></p>
        <table border="1">
            <tr>
            <th>id</th>
            <th>titulo</th>
            <th>contenido</th>
            <th></th>
            <th></th>
            </tr>
            <c:forEach var="item" item="$(avisos)">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.contenido}</td>
                    <td> <a href="inicio?action=edit&id=${item.id}">editar</a></td>
                     <td> <a href="inicio?action=delete&id=${item.id}" onclick="return (confirm('esta seguro'))" > eliminar </a></td>
                </tr>
            </c:forEach>
            </table>
    
    </body>
</html>

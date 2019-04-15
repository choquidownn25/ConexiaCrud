<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prueba Conexa</title>
</head>
<body>

<body>
	<center>
		<h1>Cocinero</h1>
        <h2>
        	<a href="new">Crear Cocinero</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista Cocinero</a>
        	
        </h2>
	</center>
    <div align="center">
        <table class="table table-hover">
            <caption><h2>Listar de Cocinero</h2></caption>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Ultimo Nombre</th>
                <th scope="col">Ultimo Nombre</th>
                <th scope="col">Ultimo Nombre</th>

            </tr>
            <c:forEach var="book" items="${getCocineros}">
                <tr>
                    <td scope="row"><c:out value="${Camarero.IdCocinero}" /></td>
                    <td scope="row"><c:out value="${Camarero.Nombre}" /></td>
                    <td scope="row"><c:out value="${Camarero.Apellido1}" /></td>
                    <td scope="row"><c:out value="${Camarero.Apellido2}" /></td>

                    
                    <td>
                    	<a href="edit?IdCocinero=<c:out value='${Camarero.IdCocinero}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?IdCocinero=<c:out value='${Camarero.IdCocinero}' />">Eliminar</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>


</body>
</html>
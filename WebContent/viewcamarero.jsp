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
		<h1>Camarero</h1>
        <h2>
        	<a href="new">Crear Camarero</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista Camarero</a>
        	
        </h2>
	</center>
    <div align="center">
        <table class="table table-hover">
            <caption><h2>Listar de Camarero</h2></caption>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido uno</th>
                <th scope="col">Apellido dos</th>

            </tr>
            <c:forEach var="book" items="${getCamareros}">
                <tr>
                    <td scope="row"><c:out value="${Camarero.IdCamarero}" /></td>
                    <td scope="row"><c:out value="${Camarero.Nombre}" /></td>
                    <td scope="row"><c:out value="${Camarero.Apellido1}" /></td>
                    <td scope="row"><c:out value="${Camarero.Apellido2}" /></td>

                    
                    <td>
                    	<a href="edit?IdCamarero=<c:out value='${Camarero.IdCamarero}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?IdCamarero=<c:out value='${Camarero.IdCamarero}' />">Eliminar</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>

</body>
</html>
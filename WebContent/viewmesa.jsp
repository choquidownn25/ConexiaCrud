<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Prueba Conexa</title>
</head>
<body>

<%@page import="com.programmingfree.controller.CRUDController"%>
<%@ page import="java.util.Date" %>


	<center>
		<h1>Mesa</h1>
        <h2>
        	<a href="new">Crear Mesa</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista Mesa</a>
        	
        </h2>
	</center>
    <div align="center">
        <table class="table table-hover">
            <caption><h2>Listar de Mesa</h2></caption>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Num Max Comensaja</th>
                <th scope="col">Ultimo Nombre</th>

            </tr>
            <c:forEach var="book" items="${getMesas}">
                <tr>
                    <td scope="row"><c:out value="${Mesa.IdMesa}" /></td>
                    <td scope="row"><c:out value="${Mesa.NumMaxComensaja}" /></td>
                    <td scope="row"><c:out value="${Mesa.lastname}" /></td>
                    
                    <td>
                    	<a href="edit?id=<c:out value='${Mesa.IdMesa}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${Mesa.IdMesa}' />">Eliminar</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>



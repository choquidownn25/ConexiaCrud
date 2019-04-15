<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prueba Conexa</title>
</head>


<body>
	<center>
		<h1>Factura</h1>
        <h2>
        	<a href="new">Crear Factura</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista Factura</a>
        	
        </h2>
	</center>
    <div align="center">
        <table class="table table-hover">
            <caption><h2>Listar de Factura</h2></caption>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Cliente</th>
                <th scope="col">Camarero</th>
                <th scope="col">Mesa</th>
                <th scope="col">Fecha Factura</th>

            </tr>
            <c:forEach var="book" items="${getFacturas}">
                <tr>
                 <td scope="row"><c:out value="${Factura.IdFactura}" /></td>
                    <td scope="row"><c:out value="${Factura.IdCliente}" /></td>
                    <td scope="row"><c:out value="${Factura.IdCamarero}" /></td>
                    <td scope="row"><c:out value="${Factura.IdMesa}" /></td>
                    <td scope="row"><c:out value="${Factura.FechaFactura}" /></td>

                    
                    <td>
                    	<a href="edit?IdFactura=<c:out value='${Factura.IdFactura}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?IdFactura=<c:out value='${Factura.IdFactura}' />">Eliminar</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>



</html>
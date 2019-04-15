<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>



<body>
	<center>
		<h1>Detalle Factura</h1>
        <h2>
        	<a href="new">Crear Detalle Factura</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista DetalleFactura</a>
        	
        </h2>
	</center>
    <div align="center">
        <table class="table table-hover">
            <caption><h2>Listar de Detalle Factura</h2></caption>
            <tr>
            	<th scope="col">Factura</th>
                <th scope="col">ID</th>
                
                <th scope="col">Cocinero</th>
                <th scope="col">Plato</th>
                <th scope="col">Importe</th>

            </tr>
            <c:forEach var="book" items="${getDetalleFacturas}">
                <tr>
                 <td scope="row"><c:out value="${DetalleFactura.IdFactura}" /></td>
                    <td scope="row"><c:out value="${DetalleFactura.IdDetalleFactura}" /></td>
                    <td scope="row"><c:out value="${DetalleFactura.IdCocinero}" /></td>
                    <td scope="row"><c:out value="${DetalleFactura.IdMesa}" /></td>
                    <td scope="row"><c:out value="${DetalleFactura.FechaFactura}" /></td>

                    
                    <td>
                    	<a href="edit?IdDetalleFactura=<c:out value='${DetalleFactura.IdDetalleFactura}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?IdDetalleFactura=<c:out value='${DetalleFactura.IdDetalleFactura}' />">Eliminar</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>




</html>
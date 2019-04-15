<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prueba Conexia</title>
</head>



<body>

	<center>
		<h1>Factura</h1>
        <h2>
        	<a href="new">Crea Factura</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista DetalleFactura</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${detalleFactura != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${detalleFactura == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${detalleFactura != null}">
            			Edita Factura
            		</c:if>
            		<c:if test="${detalleFactura == null}">
            			Crea Factura
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${detalleFactura != null}">
        			<input type="hidden" name="id" value="<c:out value='${detalleFactura.IdFactura}' />" />
        		</c:if>            
            <tr>
                <th>DetalleFactura: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${detalleFactura.IdDetalleFactura}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Cocinero: </th>
                <td>
                	<input type="text" name="author" size="45"
                			value="<c:out value='${detalleFactura.IdCocinero}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Plato: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${detalleFactura.Plato}' />"
                	/>
                </td>
            </tr>
            
             <tr>
                <th>Importe: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${detalleFactura.Importe}' />"
                	/>
                </td>
            </tr>
            

            
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	

</body>



</html>
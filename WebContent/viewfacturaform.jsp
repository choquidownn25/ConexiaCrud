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
        	<a href="list">Lista Factura</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${factura != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${factura == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${factura != null}">
            			Edita Factura
            		</c:if>
            		<c:if test="${factura == null}">
            			Crea Factura
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${factura != null}">
        			<input type="hidden" name="id" value="<c:out value='${factura.IdFactura}' />" />
        		</c:if>            
            <tr>
                <th>Nombre: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${factura.IdCliente}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Apellido uno: </th>
                <td>
                	<input type="text" name="author" size="45"
                			value="<c:out value='${factura.IdCamarero}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Apellido dos: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${factura.IdMesa}' />"
                	/>
                </td>
            </tr>
            
             <tr>
                <th>Apellido dos: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${factura.FechaFactura}' />"
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
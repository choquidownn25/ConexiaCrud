<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Prueba Conexia</title>
</head>

<body>

	<center>
		<h1>Cocinero</h1>
        <h2>
        	<a href="new">Crea Cocinero</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista Cocinero</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${cocinero != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${cocinero == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${cocinero != null}">
            			Edita Camarero
            		</c:if>
            		<c:if test="${cocinero == null}">
            			Crea Camarero
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${cocinero != null}">
        			<input type="hidden" name="id" value="<c:out value='${cocinero.IdCamarero}' />" />
        		</c:if>            
            <tr>
                <th>Nombre: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${cocinero.Nombre}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Apellido uno: </th>
                <td>
                	<input type="text" name="author" size="45"
                			value="<c:out value='${cocinero.Apellido1}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Apellido dos: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${cocinero.Apellido2}' />"
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


</html>

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
		<h1>Camarero</h1>
        <h2>
        	<a href="new">Crea Camarero</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista Camarero</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${camarero != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${camarero == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${camarero != null}">
            			Edita Camarero
            		</c:if>
            		<c:if test="${camarero == null}">
            			Crea Camarero
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${camarero != null}">
        			<input type="hidden" name="id" value="<c:out value='${camarero.IdCamarero}' />" />
        		</c:if>            
            <tr>
                <th>Nombre: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${camarero.Nombre}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Apellido uno: </th>
                <td>
                	<input type="text" name="author" size="45"
                			value="<c:out value='${camarero.Apellido1}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Apellido dos: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${camarero.Apellido2}' />"
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>Prueba Conexia</title>
</head>
<body>
	<center>
		<h1>Mesa</h1>
        <h2>
        	<a href="new">Crea Mesa</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Lista Mesa</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${mesa != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${mesa == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${mesa != null}">
            			Edita Mesa
            		</c:if>
            		<c:if test="${mesa == null}">
            			Crea Mesa
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${mesa != null}">
        			<input type="hidden" name="id" value="<c:out value='${mesa.IdMesa}' />" />
        		</c:if>            
           
           
            <tr>
                <th>Maximo: </th>
                <td>
                	<input type="text" name="author" size="45"
                			value="<c:out value='${mesa.NumMaxComensaja}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Ubicación: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${mesa.Ubicacion}' />"
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

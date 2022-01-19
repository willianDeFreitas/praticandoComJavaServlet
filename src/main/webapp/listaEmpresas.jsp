<%@ page import="java.util.List, br.com.will.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista Empresas</title>
	</head>
	<body>
		Lista de Empresas: <br>
		<ul>
			<c:forEach items="${empresas}" var="empresa">

				<li>
					${empresa.nome} -
					<fmt:formatDate value="${empresa.dataAbertura}"
						pattern="dd/MM/yyyy"/>
				</li>

			</c:forEach>
		</ul>
	</body>
</html>
<%@ page import="java.util.List,br.com.will.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista Empresas</title>
	</head>
	<body>
		<c:if test="${not empty empresa }">
			Empresa ${ empresa } cadastrada com sucesso!!
		</c:if>
		
		Lista de Empresas: <br>
		
		<ul>
			<c:forEach items="${empresas}" var="empresa">

				<li>
					${empresa.nome} -
					<fmt:formatDate value="${empresa.dataAbertura}"
						pattern="dd/MM/yyyy"/>
					<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
					<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a>
				</li>

			</c:forEach>
		</ul>
	</body>
</html>
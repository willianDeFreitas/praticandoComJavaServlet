<%@ 
	page import="java.util.List, br.com.will.gerenciador.servlet.Empresa"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista Empresas</title>
	</head>
	<body>
		Lista de Empresas: <br>
		<ul>
			<% 
				List<Empresa> empresas = (List<Empresa>)request.getAttribute("empresas");
				for (Empresa empresa : empresas) {
			%>
					<li><%=empresa.getNome()%></li>
			<%
				}
			%>
			
		</ul>
	</body>
</html>
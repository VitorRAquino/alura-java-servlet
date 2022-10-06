<%@ page import="br.com.gerenciador.servlet.Empresa" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="ISO-8859-1">
</head>
<body>
    Lista de empresas: <br />
<ul>
    <%
        List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
        for (Empresa empresa : lista) {
    %>
    <li><%= empresa.getNome() %>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>

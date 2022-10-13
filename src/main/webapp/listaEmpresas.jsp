<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, br.com.gerenciador.servlet.RemoveEmpresaServlet" %>
<%@ page import="java.util.List, br.com.gerenciador.modelo.Empresa" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista de Empresas</title>
</head>
<body>
<c:if test="${not empty empresa}">
    <p>Empresa ${ empresa } cadastrada com sucesso!</p>
</c:if>
<p>Lista de empresas: <br/>
<ul>
    <c:forEach items="${empresas}" var="empresa">
        <c:url value="/entrada?acao=MostraEmpresa&id=${empresa.id}" var="linkMostraEmpresa"/>
        <c:url value="/entrada?acao=RemoveEmpresa&id=${empresa.id}" var="linkRemoveEmpresa"/>
        <li>
            ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
            <a href="${linkMostraEmpresa}">edita</a>
            <a href="${linkRemoveEmpresa}">remove</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>

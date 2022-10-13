<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<ul>
    <c:if test="${not empty empresa}">
        <p>Empresa ${ empresa } cadastrada com sucesso!</p>
    </c:if>

    <c:if test="${empty empresa}">
        <p>Nenhuma Empresa cadastrada!</p>
    </c:if>

    <c:if test="${not empty error}">
        <p>Erros: ${error}</p>
    </c:if>
</ul>
</body>
</html>


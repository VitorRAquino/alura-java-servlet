<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=NovaEmpresa" var="linkEntrada"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Empresa Cadastro</title>
</head>
<body>
<form action="${linkEntrada}" method="post">

    Nome: <input type="text" name="nome"/>
    Data Abertura: <input type="text" name="data"/>
    <input type="submit"/>
</form>
</body>
</html>
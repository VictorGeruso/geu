<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Gerenciador de Espaços</title>
	
	<link href="/geu/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/geu/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/geu//css/app.css" rel="stylesheet">
	
</head>
<body>
	<c:import url="topo.jsp"></c:import>
		<div class="container">
			<div class="page-header">
				<h1> Inserir Espaços </h1>
			</div>
			<form action="reservas" method="post">
				Espaço: <select name="espaco">
							<option value="" selected>Selecione</option>
							<c:forEach var="espaco" items="${listaespaco}">
								<option value="${espaco.id}">${espaco.identificacao}</option>
							</c:forEach>
						</select><br>
				Titulo: <input name="titulo" type="text"><br>
				Descriçao: <input name="descricao" type="text"><br>
				Justificativa: <input name="justificativa" type="text"><br>
				Solicitante: <input name="solicitante" type="text"><br>
				telefone: <input name="telefone" type="text"><br>
				Data (dd/MM/yyyy): <input name="data" type="text"><br>
				Inicio (Hora HH:MM): <input name="inicio" type="text"><br>
				Fim (Hora HH:MM): <input name="fim" type="text"><br>
				<button type="submit">Salvar</button>
			</form>
		</div>
	<c:import url="rodape.jsp"></c:import>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    	<script src="/geu/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
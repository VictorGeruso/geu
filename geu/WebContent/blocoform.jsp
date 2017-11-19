<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
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
			<h1>Inserir Bloco</h1>
		</div>
		<form action="blocos" method="post">
			<div class="form-group">
				Nome: <input type="text" class="form-control" name="nome" />
			</div>
			<div class="form-group">
				Letra: <input type="text" class="form-control" name="letra" />
			</div>
			<div class="form-group">
				Latitude: <input type="text" class="form-control" name="latitude" />
			</div>
			<div class="form-group">
				Longitude: <input type="text" class="form-control" name="longitude" />
			</div>
			<input type="submit" class="btn btn-primary" value="Salvar" />

		</form>
	</div>

	<c:import url="rodape.jsp"></c:import>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="/geu/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
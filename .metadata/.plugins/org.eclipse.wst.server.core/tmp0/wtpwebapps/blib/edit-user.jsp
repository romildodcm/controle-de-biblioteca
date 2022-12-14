<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="models.User, models.UserType, java.util.List"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>blib | IFPR</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<link href="<%= request.getContextPath() %>/assets/css/style.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
<div class="container">

<header>
    <div class="d-flex flex-column flex-md-row align-items-center pb-3 m-4 border-bottom">
            <a href="<%= request.getContextPath() %>" class="d-flex align-items-center text-dark text-decoration-none">
        <span class="fs-4">BLIB</span>
      </a>

      <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
        <a class="me-3 py-2 text-dark text-decoration-none" href="<%= request.getContextPath() %>/books">Livros</a>
        <a class="me-3 py-2 text-dark text-decoration-none" href="<%= request.getContextPath() %>/users">Usuários</a>
        <a class="py-2 text-dark text-decoration-none" href="#">Sair</a>
      </nav>
    </div>

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
      <h1 class="display-4 fw-normal">Usuários Cadastrados</h1>
      <p class="fs-5 text-muted">Quickly build an effective pricing table for your potential customers with this Bootstrap example. It’s built with default Bootstrap components and utilities with little customization.</p>
    </div>
  </header>

	<% User u = (User) request.getAttribute("user"); %>

	<form action="<%= request.getContextPath() %>/users/edit" method="post">
	
		<div class="mb-3">
		  <label for="id" class="form-label">#id</label>
		  <input type="number" name="field-id" class="form-control" id="id" value="<%= u.getId() %>" readonly>
		</div>
		
		<div class="mb-3">
		  <label for="name" class="form-label">Nome</label>
		  <input type="text" name="field-name" class="form-control" id="name" value="<%= u.getName() %>">
		</div>
		
		<div class="mb-3">
		  <label for="name" class="form-label">Usuário</label>
		  <input type="text" name="field-username" class="form-control" id="name" value="<%= u.getUsername() %>">
		</div>
		
		<div class="mb-3">
		  <label for="name" class="form-label">Nova senha</label>
		  <input type="password" name="field-password" class="form-control" id="name" value="<%= u.getPassword() %>">
		</div>
		
		<div class="mb-3">
		  <label for="price" step='0.01' class="form-label">Tipo</label>
		  <select name="field-type" class="form-select" aria-label="Default select example" id="price">
		    <option selected value="<%= u.getType().toInteger() %>"><%= u.getType().toString() %></option>
		    <option value="0">Administrador</option>
		    <option value="1">Outro</option>
		  </select>
		</div>
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="atualizar" name="submit">
		</div>
	
	</form>

</div>
</body>
</html>
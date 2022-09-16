<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="models.Book, models.BookStatus, java.util.List"%>
<%
String path = request.getContextPath();
Integer type = (Integer) session.getAttribute("type");
Boolean login = (Boolean) session.getAttribute("login");

try {
	if (login == null || login != true || type == null || type != 0) {
		request.setAttribute("errorMessage", "Ops! Usuário sem permissão.");
		response.sendRedirect("blib.jsp");
}
} catch (Exception e) {
	System.out.println(e.getMessage());
} 

String displayError = "";
String displayMessage = "";
String errorMessage = (String) request.getAttribute("errorMessage");
String message = (String) request.getAttribute("message");

if (errorMessage != null && errorMessage.length() > 3) {
	errorMessage = "Erro: " + errorMessage + ".";
} else {
	displayError = "none";
}

if (message == null || message.isBlank()) {
	displayMessage = "none";
}
%>
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
        <a class="py-2 text-dark text-decoration-none" href="<%=path%>/logout">Sair</a>
      </nav>
    </div>

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
      <h1 class="display-4 fw-normal">Livros Cadastrados</h1>
      <p class="fs-5 text-muted">Quickly build an effective pricing table for your potential customers with this Bootstrap example. It’s built with default Bootstrap components and utilities with little customization.</p>
    </div>
  </header>

   <div class="alert alert-danger" role="alert"
          style="display: <%=displayMessage%>;">
          <%=message%>
  </div>
  <div class="alert alert-danger" role="alert"
          style="display: <%=displayError%>;">
          <%=errorMessage%>
  </div>
  
	<% Book b = (Book) request.getAttribute("book"); %>

	<form action="<%= request.getContextPath() %>/books/edit" method="post">
	
		<div class="mb-3">
		  <label for="id" class="form-label">#id</label>
		  <input type="number" name="field-id" class="form-control" id="id" value="<%= b.getId() %>" readonly>
		</div>
		
		<div class="mb-3">
		  <label for="name" class="form-label">Nome do livro</label>
		  <input type="text" name="field-name" class="form-control" id="name" value="<%= b.getName() %>">
		</div>
		
		<div class="mb-3">
		  <label for="price" step='0.01' class="form-label">Data</label>
		  <input type="text" name="field-date" class="form-control" id="price" value="<%= b.getDateFormatted()%>" >
		</div>
		
		<div class="mb-3">
		  <label for="price" step='0.01' class="form-label">Autor</label>
		  <input type="text" name="field-author" class="form-control" id="price" value="<%= b.getAuthor()%>" >
		</div>
		
		<div class="mb-3">
		  <label for="price" step='0.01' class="form-label">Status</label>
		  <select name="field-status" class="form-select" aria-label="Default select example" id="price">
		    <option selected value="<%= b.getStatus().toInteger()%>"><%= b.getStatus().toString()%></option>
		    <option value="1">Disponível</option>
		    <option value="2">Emprestado</option>
		    <option value="3">Indisponível</option>
		  </select>
		</div>
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="atualizar" name="submit">
		</div>
	
	</form>

</div>
</body>
</html>
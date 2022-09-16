<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="models.Book, models.BookStatus, java.util.List"%>
<%
String path = request.getContextPath();
String display = "none";
String funcionalidades = "Funcionalidades: vizualizar livros cadastrados na biblioteca e seus status.";

String name = (String) session.getAttribute("name");
Integer type = (Integer) session.getAttribute("type");
Boolean login = (Boolean) session.getAttribute("login");

try {
	if (login == null || login != true || type == null) {
		response.sendRedirect(path+"/login.jsp");
	}
	
	if (type == 0){
		display = "";
		funcionalidades = "Funcionalidades: cadastrar, listar, editar e excluir livros e usuários da biblioteca.";
	}
	
	
} catch (Exception e) {
	System.out.println(e.getMessage());
	//response.sendRedirect(path+"/logout");
	//RequestDispatcher dispatcher = request.getRequestDispatcher(path+"/logout");
	//dispatcher.forward(request, response);
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
	<meta charset="UTF-8">
	<title>blib | IFPR</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<link href="<%=path%>/assets/css/style.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
<div class="container">

<header>
    <div class="d-flex flex-column flex-md-row align-items-center pb-3 m-4 border-bottom">
      <a href="<%=path%>/blib" class="d-flex align-items-center text-dark text-decoration-none">
        <span class="fs-4">BLIB</span>
      </a>

      <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
        <a class="me-3 py-2 text-dark text-decoration-none" href="<%=path%>/books">Livros</a>
         <a class="me-3 py-2 text-dark text-decoration-none" style="display: <%=display%>;" href="<%=path%>/users">Usuários</a>
        <a class="py-2 text-dark text-decoration-none" href="<%=path%>/logout">Sair</a>
      </nav>
    </div>

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
      <h5 class="display-4 fw-normal">Livros Cadastrados</h5>
      <p class="fs-5 text-muted">
      	Aplicação para gerenciamento de livros, feita em Java. <br />
      	<%=funcionalidades%>
      </p>
    </div>
  </header>
  
  
  <a class="btn btn-primary" style="display: <%=display%>;" href="<%=path%>/books/register">Cadastrar livro</a>
  
  <div class="alert alert-success mt-1 mb1" role="alert"
          style="display: <%=displayMessage%>;">
          <%=message%>
  </div>
  <div class="alert alert-danger mt-1 mb1" role="alert"
          style="display: <%=displayError%>;">
          <%=errorMessage%>
  </div>
   
   <% List<Book> allbooks = (List<Book>) request.getAttribute("books");  %>
   
	<table class="table">
		<thead>
			<tr>
				<td>#id</td>
				<td>Nome</td>
				<td>Data</td>
				<td>Autor</td>
				<td>Status</td>
				<td style="display: <%=display%>;">Opções</td>
			</tr>
		</thead>
		
		<tbody>	
				
			<% for (Book b : allbooks) { %>
			<tr>
				<td><%=b.getId()%></td>
				<td><%=b.getName()%></td>
				<td><%=b.getDateFormatted()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getStatus().toString()%></td>
				<td style="display: <%=display%>;" ><a href="<%=path%>/books/edit?id=<%=b.getId()%>">Editar</a> | <a href="<%=path%>/books/delete?id=<%=b.getId()%>">Excluir</a></td>
			</tr>
			<% } %>
		</tbody>

	</table>

</div>
</body>
</html>
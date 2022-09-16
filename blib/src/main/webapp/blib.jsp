<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="models.Book, models.BookStatus, java.util.List"%>
<%
String path = request.getContextPath();
String display = "none";

String funcionalidades = "Funcionalidades: vizualizar livros cadastrados na biblioteca e seus status.";
String links = "<a href=\"" + path + "/books\">Clique aqui para acessar lista de livros</a>";

String name = (String) session.getAttribute("name");
Integer type = (Integer) session.getAttribute("type");
Boolean login = (Boolean) session.getAttribute("login");

try {
	if (login == null || login != true) {
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
      <a href="<%=path%>" class="d-flex align-items-center text-dark text-decoration-none">
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
      	<%=funcionalidades%> <br />
      	<%=links%>
      </p>
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
  
</div>
</body>
</html>
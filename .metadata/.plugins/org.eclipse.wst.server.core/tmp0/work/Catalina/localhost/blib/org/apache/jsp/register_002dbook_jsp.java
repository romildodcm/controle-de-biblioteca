/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.63
 * Generated at: 2022-09-16 04:46:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import models.Book;
import models.BookStatus;
import java.util.List;

public final class register_002dbook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("models.Book");
    _jspx_imports_classes.add("models.BookStatus");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');

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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("	<meta charset=\"utf-8\">\n");
      out.write("	<title>blib | IFPR</title>\n");
      out.write("	\n");
      out.write("	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx\" crossorigin=\"anonymous\">\n");
      out.write("	<link href=\"");
      out.print( request.getContextPath() );
      out.write("/assets/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("	\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("\n");
      out.write("<header>\n");
      out.write("    <div class=\"d-flex flex-column flex-md-row align-items-center pb-3 m-4 border-bottom\">\n");
      out.write("            <a href=\"");
      out.print( request.getContextPath() );
      out.write("\" class=\"d-flex align-items-center text-dark text-decoration-none\">\n");
      out.write("        <span class=\"fs-4\">BLIB</span>\n");
      out.write("      </a>\n");
      out.write("\n");
      out.write("      <nav class=\"d-inline-flex mt-2 mt-md-0 ms-md-auto\">\n");
      out.write("        <a class=\"me-3 py-2 text-dark text-decoration-none\" href=\"");
      out.print( request.getContextPath() );
      out.write("/books\">Livros</a>\n");
      out.write("        <a class=\"me-3 py-2 text-dark text-decoration-none\" href=\"");
      out.print( request.getContextPath() );
      out.write("/users\">Usuários</a>\n");
      out.write("        <a class=\"py-2 text-dark text-decoration-none\" href=\"");
      out.print(path);
      out.write("/logout\">Sair</a>\n");
      out.write("      </nav>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"pricing-header p-3 pb-md-4 mx-auto text-center\">\n");
      out.write("      <h1 class=\"display-4 fw-normal\">Livros Cadastrados</h1>\n");
      out.write("      <p class=\"fs-5 text-muted\">Quickly build an effective pricing table for your potential customers with this Bootstrap example. It’s built with default Bootstrap components and utilities with little customization.</p>\n");
      out.write("    </div>\n");
      out.write("  </header>\n");
      out.write("  \n");
      out.write("   <div class=\"alert alert-danger\" role=\"alert\"\n");
      out.write("          style=\"display: ");
      out.print(displayMessage);
      out.write(";\">\n");
      out.write("          ");
      out.print(message);
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <div class=\"alert alert-danger\" role=\"alert\"\n");
      out.write("          style=\"display: ");
      out.print(displayError);
      out.write(";\">\n");
      out.write("          ");
      out.print(errorMessage);
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("	");
 Book b = (Book) request.getAttribute("book"); 
      out.write("\n");
      out.write("\n");
      out.write("	<form action=\"");
      out.print( request.getContextPath() );
      out.write("/books/register\" method=\"post\">\n");
      out.write("		\n");
      out.write("		<div class=\"mb-3\">\n");
      out.write("		  <label for=\"name\" class=\"form-label\">Nome do livro</label>\n");
      out.write("		  <input type=\"text\" name=\"field-name\" class=\"form-control\" id=\"name\">\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		<div class=\"mb-3\">\n");
      out.write("		  <label for=\"price\" step='0.01' class=\"form-label\">Data</label>\n");
      out.write("		  <input type=\"text\" name=\"field-date\" class=\"form-control\" id=\"price\">\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		<div class=\"mb-3\">\n");
      out.write("		  <label for=\"price\" step='0.01' class=\"form-label\">Autor</label>\n");
      out.write("		  <input type=\"text\" name=\"field-author\" class=\"form-control\" id=\"price\">\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		<div class=\"mb-3\">\n");
      out.write("		  <label for=\"price\" step='0.01' class=\"form-label\">Status</label>\n");
      out.write("		  <select name=\"field-status\" class=\"form-select\" aria-label=\"Default select example\" id=\"price\">\n");
      out.write("		    <option selected value=\"1\">Disponível</option>\n");
      out.write("		    <option value=\"1\">Disponível</option>\n");
      out.write("		    <option value=\"2\">Emprestado</option>\n");
      out.write("		    <option value=\"3\">Indisponível</option>\n");
      out.write("		  </select>\n");
      out.write("		</div>\n");
      out.write("		\n");
      out.write("		<div class=\"mb-3\">\n");
      out.write("			<input class=\"btn btn-primary\" type=\"submit\" value=\"Cadastrar\" name=\"submit\">\n");
      out.write("		</div>\n");
      out.write("	\n");
      out.write("	</form>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
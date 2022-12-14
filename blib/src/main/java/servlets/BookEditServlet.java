package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Book;
import models.Tools;
import models.UserType;
import repository.IBookRepository;
import repository.BookRepository;

@MultipartConfig
@WebServlet("/books/edit")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IBookRepository repository = new BookRepository();
		req.setCharacterEncoding("utf-8");
		String errorMessage = "";
		
		HttpSession session = req.getSession(false);
		RequestDispatcher dispatcher = req.getRequestDispatcher("../blib.jsp");
        
        try {
        	Integer type = (Integer) session.getAttribute("type");
            Boolean login = (Boolean) session.getAttribute("login");
            
            if (type == UserType.ADMIN.toInteger() && login == true) {
            	try {
            		System.out.println("ID parameter edit servlet: " + req.getParameter("id"));
            		
            		if (req.getParameter("id") != null) {
            			Integer id = Integer.valueOf(req.getParameter("id"));
            			Book book = repository.find(id);
            			
            			req.setAttribute("book", book);
            			dispatcher = req.getRequestDispatcher("/edit-book.jsp");
            			dispatcher.forward(req, resp);
            		} 
            		
            		if (Tools.isStringNullOrEmpty(req.getParameter("field-name"))
        					|| Tools.isStringNullOrEmpty(req.getParameter("field-date"))
        					|| Tools.isStringNullOrEmpty(req.getParameter("field-author"))
        					|| Tools.isStringNullOrEmpty(req.getParameter("field-status"))
        					|| Tools.isStringNullOrEmpty(req.getParameter("field-id"))){
        				throw new Exception("Preencha todos os campos");
            		} else {
            			Book book = new Book();
            			
            			book.setId(Integer.valueOf(req.getParameter("field-id")));
            			book.setName(req.getParameter("field-name"));
            			// field-date, string to LocalDate 'dd/MM/yyyy'
            			book.setDate(java.time.LocalDate.parse(req.getParameter("field-date"), java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            			book.setAuthor(req.getParameter("field-author"));
            			book.setStatus(Integer.valueOf(req.getParameter("field-status")));
            			
            			repository.update(book);
            			req.setAttribute("message", "Livro atualizado: "+book.getName());
            			dispatcher = req.getRequestDispatcher("/books");
            			//dispatcher.forward(req, resp);
            		}
            	} catch (Exception e) {
        			errorMessage = e.getMessage();
        			System.out.println(errorMessage);
                	req.setAttribute("errorMessage", errorMessage);
                	
                	Integer id = Integer.valueOf(req.getParameter("field-id"));
        			Book book = repository.find(id);
        			
        			req.setAttribute("book", book);
        			dispatcher = req.getRequestDispatcher("../edit-book.jsp");
        			// add no final
					//dispatcher.forward(req, resp);
        		}
            } else {
            	throw new Exception("Ops! Usu??rio sem permiss??o.");
            }
        } catch (Exception e){
        	System.out.println(e.getMessage());
        	errorMessage = e.getMessage();
        	req.setAttribute("errorMessage", errorMessage);
        	dispatcher = req.getRequestDispatcher("../blib.jsp");
        }
        
        dispatcher.forward(req, resp);
        
	}
}

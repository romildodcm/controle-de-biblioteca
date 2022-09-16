package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Book;
import repository.BookRepository;

//@WebServlet(name = "books" ,urlPatterns = {"", "/books"})
@WebServlet("/books")
public class BookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 13L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        String errorMessage = "";
       
        HttpSession session = req.getSession(false);
        RequestDispatcher dispatcher = req.getRequestDispatcher("./login.jsp");
        
        try {
            Boolean login = (Boolean) session.getAttribute("login");
            
        	if (login == true) {
        		BookRepository repository = new BookRepository();
        		List<Book> books = new ArrayList<>();
        		
        		try {
        			System.out.println("lendo livros");
        			books = repository.findAll();
        			
        			// log
        			//for(Book b : books) {
        			//	System.out.println(b.getId()  + " - " + b.getName());
        			//}
        			
        			System.out.println("chamando books.jsp");
        			req.setAttribute("books", books);
        			
            		dispatcher = req.getRequestDispatcher("books.jsp");
            		dispatcher.forward(req, resp);
        		} catch (Exception e) {
        			System.out.println(e.getMessage());
        			errorMessage = e.getMessage();
        			
        			req.setAttribute("errorMessage", errorMessage);
            		req.setAttribute("books", books);
            		System.out.println("chamando books.jsp");
            		
            		dispatcher = req.getRequestDispatcher("books.jsp");
            		dispatcher.forward(req, resp);
        		}
        	} else {
        		throw new Exception("Ops! Faça login para acessar.");
        	}
        } catch (Exception e){
        	System.out.println(e.getMessage());
        	errorMessage = e.getMessage();
        	
        	req.setAttribute("errorMessage", errorMessage);
        	dispatcher = req.getRequestDispatcher("./login.jsp");
        	dispatcher.forward(req, resp);
        }
	}

}

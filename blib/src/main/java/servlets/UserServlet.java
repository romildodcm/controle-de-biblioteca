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

import models.User;
import models.UserType;
import repository.UserRepository;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 12L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        String errorMessage = "";
        //String path = req.getContextPath();
        
        HttpSession session = req.getSession(false);
        
        try {
        	Integer type = (Integer) session.getAttribute("type");
            Boolean login = (Boolean) session.getAttribute("login");
            
        	if (type == UserType.ADMIN.toInteger() && login == true) {
        		UserRepository repository = new UserRepository();
        		List<User> users = new ArrayList<>();
        		
        		//System.out.println("Log: fez login");
        		try {
        			users = repository.findAll();
        		} catch (Exception e) {
        			System.out.println(e.getMessage());
        			errorMessage = "erro ao buscar usuarios";
        		}
        		
        		req.setAttribute("users", users);
        		req.setAttribute("errorMessage", errorMessage);
        		
        		RequestDispatcher dispatcher = req.getRequestDispatcher("users.jsp");
        		dispatcher.forward(req, resp);
        	} else {
        		errorMessage = "ops! Usuário sem permissão";
        	}
        } catch (Exception e){
        	System.out.println(e.getMessage());
        	errorMessage = "ops! Usuário sem permissão";
        }
        
        req.setAttribute("errorMessage", errorMessage);
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/blib.jsp");
        dispatcher.forward(req, resp);
	}
}
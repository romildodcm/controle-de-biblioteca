package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tools;
import model.User;
import repository.IUserRepository;
import repository.UserRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    IUserRepository userRepository = new UserRepository();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

		HttpSession sessao = req.getSession(true);

        String username = req.getParameter("field-user");
        String password = req.getParameter("field-password");
		
        User user = new User();

		if(isValidLogin(username, password)) {
            user = userRepository.find(username);

            sessao.setAttribute("loginStatus", true);
            sessao.setAttribute("name", user.getName());
            sessao.setAttribute("type", user.getType().toInteger());

			resp.sendRedirect("./book.jsp");
        } else {
            sessao.setAttribute("loginStatus", false);
            req.setAttribute("errorMessage", "usuário ou senha inválidos");

            RequestDispatcher dispatcher = req.getRequestDispatcher("./login.jsp");
            dispatcher.forward(req, resp);
        }
	}

    public boolean isValidLogin(String username, String password) {
        if(!Tools.isStringNullOrEmpty(username) || !Tools.isStringNullOrEmpty(password)) {
            User user = userRepository.find(username);

            if(user != null && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }
}
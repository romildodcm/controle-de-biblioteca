package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.IUserRepository;
import repository.UserRepository;

import model.User;

@WebServlet("/createaccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    IUserRepository userRepository = new UserRepository();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession(false);
        
        if (session !=null || session.getAttribute("type").equals(0)) {
            String errors = "";

            String name = req.getParameter("field-name");
            String username = req.getParameter("field-user");
            String password = req.getParameter("field-password");
            String passwordConfirmation = req.getParameter("field-password-confirmation");
            int type = Integer.parseInt(req.getParameter("field-type"));

            if (name == null || name.trim().isEmpty() || name.length() < 3) {
                errors += "Nome inválido. ";
            }

            if(!User.isValidUsername(username)) {
                errors += "Usuário inválido. ";
            }

            if(!User.isValidPassword(password)) {
                errors += "Senha inválida. ";
            }

            if(!password.equals(passwordConfirmation)) {
                errors += "Senhas não conferem. ";
            }

            if(!User.isValidType(type)) {
                errors += "Tipo inválido. ";
            }

            if (errors.equals("")) {
                User user = new User(name, username, password, type);

                if (userRepository.find(username) == null) {
                    userRepository.insert(user);

                    req.setAttribute("message", "Usuário cadastrado com sucesso!");

                    resp.sendRedirect("./users.jsp");
                } else {
                    errors += "Usuário já cadastrado. ";
                }
            } else {
                req.setAttribute("message", "Erro ao cadastrar usuário!");
                req.setAttribute("errorMessage", errors);

                RequestDispatcher dispatcher = req.getRequestDispatcher("./create-account.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "Você não tem permissão para criar usuários.");
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("./index.jsp");
            dispatcher.forward(req, resp);
        }

        
    }
}
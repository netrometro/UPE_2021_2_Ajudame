package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;

import br.upe.ajudame.model.entities.User;
import br.upe.ajudame.model.repositories.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/entrar")
public class UserEnterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserEnterController() {
        super();
    }

	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		System.out.println("POST:: User Enter");

		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("pass"));
		
		User user = null;
		try {
			UserDAO dao = new UserDAO();
			user = dao.autentication(request.getParameter("email"), request.getParameter("pass"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (user != null) {
			System.out.println(user.getEmail());
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect("dashboard");
		} else {
		
		//Mensagem de erro
		response.sendRedirect("index.jsp");
		}
	}
}

package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;

import br.upe.ajudame.model.entities.User;
import br.upe.ajudame.model.repositories.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DashboardController() {
        super();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		System.out.println("GET:: Dashboard");
		
		HttpSession session = request.getSession(false);
		if (session != null) {
		    User user = (User) session.getAttribute("user");

			request.setAttribute("user", user);
			
			RequestDispatcher despachar = request.getRequestDispatcher("dashboard.jsp");
			despachar.forward(request, response);
		} else {
		
		// Adicionar mensagem de erro
		response.sendRedirect("index.jsp");
		}
	}
}

package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.entities.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public RegisterUserController() {
        super();
    }
    
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("email"));
	
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		
		request.setAttribute("user", user);
		
		RequestDispatcher despachar = request.getRequestDispatcher("/user.jsp");
		despachar.forward(request, response);
	}
}

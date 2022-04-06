package br.upe.ajudame.controllers;

import java.io.IOException;

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
		
		
		System.out.println(request.getAttribute("name"));
	
	}
}

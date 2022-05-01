package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/curso/get")
public class CursoListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CursoListController() 
	{
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("GET: Cursos List");
		System.out.println("Pegar lista de cursos");
		RequestDispatcher despachar = req.getRequestDispatcher("/CursosList.jsp");
		despachar.forward(req, resp);
	}

}

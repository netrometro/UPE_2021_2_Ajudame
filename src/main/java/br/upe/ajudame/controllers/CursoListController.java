package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.upe.ajudame.model.entities.Cursos;
import br.upe.ajudame.model.repositories.CursosDAO;
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
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("GET: Cursos List");

		try {
			CursosDAO dao = new CursosDAO();
			
			ArrayList<Cursos> lista = (ArrayList<Cursos>) dao.list();
			
			req.setAttribute("cursos", lista);
			
			RequestDispatcher despachar = req.getRequestDispatcher("/ListaCursos.jsp");
			despachar.forward(req, resp);
		} catch (Exception e) {
			
		}
		
	}

}

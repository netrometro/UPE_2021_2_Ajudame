package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.entities.Cursos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/curso")
public class CursosController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CursosController() {
		super();
	}
	
	protected void doPost(
			HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException 
		{

			String nomeCurso = req.getParameter("nameCurso");
			String description = req.getParameter("description");
		
			Cursos curso = new Cursos();
			
			curso.setNameCurso(nomeCurso);
			curso.setDescription(description);
			
			req.setAttribute("curso", curso);
			
			//Falta criar uma pagina para adicionar novos cursos, a mesma deve conter um "innerHTML" ou algo parecido.
			RequestDispatcher despachar = req.getRequestDispatcher("/Cursos.jsp");
			despachar.forward(req, resp);
		}
}

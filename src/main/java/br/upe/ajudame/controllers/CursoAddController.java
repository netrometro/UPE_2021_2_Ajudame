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

@WebServlet("/addCurso")
public class CursoAddController {

	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		System.out.println("POST:: Cursos Add");

		System.out.println(request.getParameter("nameCurso"));
		System.out.println(request.getParameter("description"));
		
		Cursos curso = new Cursos();
		curso.setNameCurso(request.getParameter("nameCurso"));
		curso.setDescription(request.getParameter("description"));
		
		CursosDAO dao = new CursosDAO();
		dao.add(curso);
		
		request.setAttribute("curso", curso);
		
		RequestDispatcher despachar = request.getRequestDispatcher("/ListaCursos.jsp");
		despachar.forward(request, response);

	}
	
}

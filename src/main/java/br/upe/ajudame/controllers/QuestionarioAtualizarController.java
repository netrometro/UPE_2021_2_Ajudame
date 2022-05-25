package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.entities.Cursos;
import br.upe.ajudame.model.entities.Questionario;
import br.upe.ajudame.model.repositories.QuestionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/questionario/atualizar")
public class QuestionarioAtualizarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionarioAtualizarController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String novoCurso = request.getParameter("nameCurso");

		String questionarioRecebido = request.getParameter("questionario");

		int questionario_id = Integer.parseInt(questionarioRecebido);
		
		Questionario questionario = new Questionario();
		questionario.setId(questionario_id);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();

		System.out.println(novoCurso);
		try {
			Cursos curso = new Cursos();
			curso = questionarioDAO.searchCurso(novoCurso);
			
			questionario.setCurso(curso);
			questionarioDAO.update(questionario);
			
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

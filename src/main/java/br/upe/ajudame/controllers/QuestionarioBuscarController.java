package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.entities.Cursos;
import br.upe.ajudame.model.repositories.QuestionarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/questionario/buscar")
public class QuestionarioBuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionarioBuscarController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curso = request.getParameter("curso");
		System.out.println(curso);
		
		String questionario = request.getParameter("questionario");
		
		int questionario_id = Integer.parseInt(questionario);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		try {
			Cursos buscarCurso = questionarioDAO.searchCurso(curso);
			
			request.setAttribute("curso", buscarCurso);
			request.setAttribute("questionario", questionario_id);
			
			RequestDispatcher despachar = request.getRequestDispatcher("/AtualizarQuestionario.jsp");
			despachar.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

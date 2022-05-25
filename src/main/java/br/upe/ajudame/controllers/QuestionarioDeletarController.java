package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.repositories.QuestionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/questionario/deletar")
public class QuestionarioDeletarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionarioDeletarController() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String questionario = request.getParameter("questionario");
		
		int id_questionario = Integer.parseInt(questionario);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		
		try {
			questionarioDAO.remove(id_questionario);
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

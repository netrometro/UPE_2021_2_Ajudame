package br.upe.ajudame.controllers;

import java.io.IOException;

import br.upe.ajudame.model.repositories.QuestaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/questionario/questao/deletar")
public class QuestaoDeletarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestaoDeletarController() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   	
    	System.out.println("Chamou!!!");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("questao");
		System.out.println(value);
		int id_questao = Integer.parseInt(value);
		
		
		
		QuestaoDAO questaoDAO = new QuestaoDAO();
		try {
			questaoDAO.remove(id_questao);
			response.sendRedirect("/upe_20212_ajudame/questionario/questoes");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

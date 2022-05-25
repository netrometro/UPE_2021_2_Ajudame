package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Alternativa;
import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.repositories.QuestaoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/questionario/questao/buscarPergunta")
public class BuscarPerguntaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Questao questao;
	
    public BuscarPerguntaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("questao", this.questao);
		
		RequestDispatcher despachar = request.getRequestDispatcher("/ResponderQuestao.jsp");
		despachar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valor = request.getParameter("questao");
		int id_questao = Integer.parseInt(valor);
		
		try {
			QuestaoDAO questaoDAO = new QuestaoDAO();
			this.questao = questaoDAO.searchByIdQuestao(id_questao);
			List<Alternativa> alternativas = new ArrayList();
			alternativas = questaoDAO.listAlternativas(id_questao);
			
			for (int i = 0; i < alternativas.size(); i++) {
				this.questao.adicionarAlternativas(alternativas.get(i));
			}
			
			response.sendRedirect("/upe_20212_ajudame/questionario/questao/buscarPergunta");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

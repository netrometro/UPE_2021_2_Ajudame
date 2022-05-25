package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Alternativa;
import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.entities.Questionario;
import br.upe.ajudame.model.repositories.QuestaoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/questionario/questoes")
public class QuestoesListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Questao> questoes = new ArrayList<Questao>();
	private Questionario questionario = new Questionario();

	public QuestoesListController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			QuestaoDAO questaoDAO = new QuestaoDAO();
			
			for (int i = 0; i < this.questoes.size(); i++) {
				int id_questao = this.questoes.get(i).getId();
				List<Alternativa> alt = questaoDAO.listAlternativas(id_questao);
				
				this.questoes.get(i).setAlternativas(alt);
			}
			
			
			request.setAttribute("questoes", this.questoes);
			
			RequestDispatcher despachar = request.getRequestDispatcher("/ListaQuestoes.jsp");
			despachar.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String value = request.getParameter("curso");
		int id_curso = Integer.parseInt(value);
		
		try {
			
			QuestaoDAO questaoDAO = new QuestaoDAO();

			this.questoes = questaoDAO.list(id_curso);
	
			response.sendRedirect("/upe_20212_ajudame/questionario/questoes");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.entities.Questionario;
import br.upe.ajudame.model.entities.User;
import br.upe.ajudame.model.repositories.QuestaoDAO;
import br.upe.ajudame.model.repositories.QuestionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/questionario")
public class QuestionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Criando um Questionario para o projeto!");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Questionario questionario = new Questionario();
		questionario.setTema(request.getParameter("tema"));
		questionario.setTotalAcertos(0);
		questionario.setTotalErros(0);
		
		List<Questao> questoes = new ArrayList<Questao>();
		
		Questao questao = new Questao();
		
		questao.setPergunta(request.getParameter("pergunta"));
		questao.setResposta(request.getParameter("resposta"));
		questao.setExplicação(request.getParameter("explicacao"));
		questao.adicionarAlternativas(request.getParameter("alternativa1"));
		questao.adicionarAlternativas(request.getParameter("alternativa2"));
		questao.adicionarAlternativas(request.getParameter("alternativa3"));
		questao.adicionarAlternativas(request.getParameter("alternativa4"));
		questao.adicionarAlternativas(request.getParameter("alternativa5"));
		
		questionario.CriarPerguntas(questao);
		
		User user = new User();
		user.setId(1);
		user.setName("fulano");
		user.setEmail("fulano@gmail.com");
		user.setPassword("112");
		
		questionario.setUser(user);
		
		QuestionarioDAO dao = new QuestionarioDAO();
		QuestaoDAO questaoDAO = new QuestaoDAO();
		try {			
			dao.add(questionario);
			int buscaQuestionario = dao.searchQuestionario(questionario.getTema());
			
			System.out.println(buscaQuestionario);
			questaoDAO.add(questao, buscaQuestionario);
			int buscaQuestao = questaoDAO.searchQuestao(questao.getPergunta());
			
			questaoDAO.addAlternativa(questao.getAlternativas(), buscaQuestao);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		response.sendRedirect("questionario");

	}

}

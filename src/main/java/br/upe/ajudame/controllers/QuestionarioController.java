package br.upe.ajudame.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Alternativa;
import br.upe.ajudame.model.entities.Cursos;
import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.entities.Questionario;
import br.upe.ajudame.model.entities.User;
import br.upe.ajudame.model.repositories.QuestaoDAO;
import br.upe.ajudame.model.repositories.QuestionarioDAO;
import br.upe.ajudame.model.repositories.UserDAO;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cursoRecebido = request.getParameter("curso");
		
		String userIdRecebido = request.getParameter("userId");
		
		int user = Integer.parseInt(userIdRecebido);
		
		Questionario questionario = new Questionario();
		
		questionario.setTotalAcertos(0);
		questionario.setTotalErros(0);
		
		List<Questao> questoes = new ArrayList<Questao>();
		
		Questao questao = new Questao();
		
		questao.setPergunta(request.getParameter("pergunta"));
		questao.setResposta(request.getParameter("resposta"));
		questao.setExplicacao(request.getParameter("explicacao"));
		
		Alternativa alternativa = new Alternativa();
		alternativa.setAlternativa(request.getParameter("alternativa1"));
		questao.adicionarAlternativas(alternativa);
		
		alternativa = new Alternativa();
		alternativa.setAlternativa(request.getParameter("alternativa2"));
		questao.adicionarAlternativas(alternativa);
		
		alternativa = new Alternativa();
		alternativa.setAlternativa(request.getParameter("alternativa3"));
		questao.adicionarAlternativas(alternativa);
		
		alternativa = new Alternativa();
		alternativa.setAlternativa(request.getParameter("alternativa4"));
		questao.adicionarAlternativas(alternativa);
		
		alternativa = new Alternativa();
		alternativa.setAlternativa(request.getParameter("alternativa5"));
		questao.adicionarAlternativas(alternativa);
		
		System.out.println("Listando Altrenativas");
		for (int i = 0; i < questao.getAlternativas().size(); i++) {
			System.out.println(questao.getAlternativas().get(i).getAlternativa());
		}
		
		questionario.CriarPerguntas(questao);
		
		QuestionarioDAO questionarioDAO = new QuestionarioDAO();
		QuestaoDAO questaoDAO = new QuestaoDAO();
		UserDAO userDAO = new UserDAO();
		
		try {	
			Cursos buscarCurso = questionarioDAO.searchCurso(cursoRecebido);
			questionario.setCurso(buscarCurso);
			int idUser = user;
			User buscarUser = questionarioDAO.searchByNameUser(idUser);
			
			questionario.setUser(buscarUser);
			
			questionarioDAO.add(questionario);
			
			int buscaQuestionario = questionarioDAO.searchQuestionario(questionario.getCurso().getId());
			
			
			questaoDAO.add(questao, buscaQuestionario);
			int buscaQuestao = questaoDAO.searchQuestao(questao.getPergunta());
			
			questaoDAO.addAlternativa(questao.getAlternativas(), buscaQuestao);
			
			response.sendRedirect("CadastrarQuestionario.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	}

}

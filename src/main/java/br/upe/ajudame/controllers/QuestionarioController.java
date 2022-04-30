package br.upe.ajudame.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.upe.ajudame.model.entities.Questao;
import br.upe.ajudame.model.entities.Questionario;
import jakarta.servlet.RequestDispatcher;
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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Criando um Questionario para o projeto!");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tema = request.getParameter("tema");
		String pergunta = request.getParameter("pergunta");
		String resposta = request.getParameter("resposta");
		String explicacao = request.getParameter("explicacao");
		String alternativa1 = request.getParameter("alternativa1");
		String alternativa2 = request.getParameter("alternativa2");
		String alternativa3 = request.getParameter("alternativa3");
		String alternativa4 = request.getParameter("alternativa4");
		String alternativa5 = request.getParameter("alternativa5");
		System.out.println(pergunta + ", " + resposta + ", " + explicacao 
				+ "a) " + alternativa1 
				+ "b) " + alternativa2 
				+ "c) " + alternativa3
				+ "d) " + alternativa4
				+ "e) " + alternativa5);
		
		List<String> alternativas = new ArrayList();
		List<Questao> questoes = new ArrayList();
		
		alternativas.add(alternativa1);
		alternativas.add(alternativa2);
		alternativas.add(alternativa3);
		alternativas.add(alternativa4);
		alternativas.add(alternativa5);
		
		Questionario questionario = new Questionario();
		Questao questao = new Questao();
		
		
		questao.setPergunta(pergunta);
		questao.setResposta(resposta);
		questao.setExplicação(explicacao);
		questao.setAlternativas(alternativas);
		
		questoes.add(questao);
		
		questionario.setTema(tema);
		questionario.setTotalAcertos(0);
		questionario.setTotalErros(0);
		questionario.setQuestoes(questoes);
		
		request.setAttribute("questionario", questionario);
		RequestDispatcher despachar = request.getRequestDispatcher("/Questionario.jsp");
		despachar.forward(request, response);
	}

}

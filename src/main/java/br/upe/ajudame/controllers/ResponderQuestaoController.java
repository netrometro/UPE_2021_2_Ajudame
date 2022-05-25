package br.upe.ajudame.controllers;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.upe.ajudame.model.entities.Questao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/questionario/questao/responder")
public class ResponderQuestaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Questao questao;
	
	private String valorRetornadoUsuario;

	public ResponderQuestaoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("respostaUsuario", this.valorRetornadoUsuario);
		
		RequestDispatcher despachar = request.getRequestDispatcher("/ResponderQuestao.jsp");
		despachar.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String resposta = request.getParameter("resposta");
			String explicacao = request.getParameter("explicacao");

			String alternativaA = request.getParameter("alternativaA");
			String alternativaB = request.getParameter("alternativaB");
			String alternativaC = request.getParameter("alternativaC");
			String alternativaD = request.getParameter("alternativaD");
			String alternativaE = request.getParameter("alternativaE");
			
			String verificarResposta = "";
			if(alternativaA != null) verificarResposta = alternativaA;
			if(alternativaB != null) verificarResposta = alternativaB;
			if(alternativaC != null) verificarResposta = alternativaC;
			if(alternativaD != null) verificarResposta = alternativaD;
			if(alternativaE != null) verificarResposta = alternativaE;
			
			
			if (verificarResposta.equals(resposta)) {
				this.valorRetornadoUsuario = "Parabéns você acertou!";
			} else {
				this.valorRetornadoUsuario = "Infelizmente você errou! " + explicacao;
			}
				
			System.out.println(this.valorRetornadoUsuario);
			
			response.sendRedirect("/upe_20212_ajudame/questionario/questoes");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
